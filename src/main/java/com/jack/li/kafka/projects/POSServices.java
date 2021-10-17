package com.jack.li.kafka.projects;

import com.jack.li.kafka.projects.serde.AppSerdes;
import com.jack.li.kafka.projects.types.*;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Arrays;
import java.util.Properties;
import java.util.stream.Collectors;

public class POSServices {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, AppConfigs.applicationID);
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootstrapServers);
        properties.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, 3);

        Serde<String> stringSerde = Serdes.String();
        Serde<POSInvoice> posInvoiceSerde = AppSerdes.PosInvoice();
        Serde<Loyalty> loyaltySerde = AppSerdes.Loyalty();
        Serde<HadoopRecord> hadoopRecordSerde = AppSerdes.HadoopRecord();
        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String, POSInvoice> validPOSInvoiceKStream = streamsBuilder.stream(AppConfigs.validPOSTopic,
                Consumed.with(stringSerde, posInvoiceSerde));

        /* Shipment Service for Home Deliveries */
        KStream<String, POSInvoice> shipmentKStream = validPOSInvoiceKStream.filter(
                (storeID, invoice) -> invoice.getDeliveryType().equals("HOME-DELIVERY")
        );
        shipmentKStream.to(AppConfigs.shipmentTopic, Produced.with(stringSerde, posInvoiceSerde));

        /* Loyalty Management Service: generate Loyalty Notification Events */
        System.out.println("Streaming loyalty events");
        KStream<String, POSInvoice> primeKStream = validPOSInvoiceKStream.filter(
                (storeID, invoice) -> invoice.getCustomerType().equals("PRIME")
        );

        System.out.println("Creating loyalty events");
        KStream<String, Loyalty> loyaltyKStream = primeKStream.mapValues(
                invoice -> {

                    Loyalty loyalty = new Loyalty();
                    loyalty.setInvoiceNumber(Integer.valueOf(invoice.getInvoiceNumber()));
                    loyalty.setCustomerCardNumber(invoice.getCustomerCardNumber());

                    Double totalAmount = invoice.getTotalAmount();
                    loyalty.setTotalAmount(totalAmount);
                    loyalty.setEarnedLoyaltyPoints(((Long) Math.round(totalAmount * AppConfigs.loyaltyRate)).intValue());
                    return loyalty;
                }
        );
        loyaltyKStream.to(AppConfigs.loyaltyTopic, Produced.with(stringSerde, loyaltySerde));

        /* Trend Analytics Service: mask personal info (CustomerCardNumber, AddressLine, and ContactNumber) and flatten
        nested JSON and array attributes into a new HadoopRecord without any nested objects. */
        System.out.println("Streaming Trend Analytics events");
        KStream<String, MaskedPOSInvoice> maskedInvoiceKStream = validPOSInvoiceKStream.mapValues(
                invoice -> {
                    MaskedPOSInvoice maskedPOSInvoice = new MaskedPOSInvoice();
                    maskedPOSInvoice.setInvoiceNumber(Integer.valueOf(invoice.getInvoiceNumber()));
                    maskedPOSInvoice.setCreatedTime(invoice.getCreatedTime());
                    maskedPOSInvoice.setStoreID(invoice.getStoreID());
                    maskedPOSInvoice.setPosID(invoice.getPosID());
                    maskedPOSInvoice.setCustomerType(invoice.getCustomerType());
                    maskedPOSInvoice.setPaymentMethod(invoice.getPaymentMethod());
                    maskedPOSInvoice.setDeliveryType(invoice.getDeliveryType());

                    DeliveryAddress deliveryAddress = invoice.getDeliveryAddress();
                    if (deliveryAddress != null) {
                        maskedPOSInvoice.setCity(deliveryAddress.getCity());
                        maskedPOSInvoice.setState(deliveryAddress.getState());
                        maskedPOSInvoice.setPinCode(deliveryAddress.getPinCode());
                    }
                    else {
                        maskedPOSInvoice.setCity("");
                        maskedPOSInvoice.setState("");
                        maskedPOSInvoice.setPinCode("");
                    }

                    maskedPOSInvoice.setInvoiceLineItems(invoice.getInvoiceLineItems());
                    return maskedPOSInvoice;
                }
        );
        KStream<String, HadoopRecord> hadoopRecordKStream = maskedInvoiceKStream.flatMapValues(maskedInvoice ->
                Arrays.stream(maskedInvoice.getInvoiceLineItems().toArray(new LineItem[0]))
                .map(lineItem -> {
                    HadoopRecord hadoopRecord = new HadoopRecord();
                    hadoopRecord.setInvoiceNumber(maskedInvoice.getInvoiceNumber());
                    hadoopRecord.setCreatedTime(maskedInvoice.getCreatedTime());
                    hadoopRecord.setStoreID(maskedInvoice.getStoreID());
                    hadoopRecord.setPosID(maskedInvoice.getPosID());
                    hadoopRecord.setCustomerType(maskedInvoice.getCustomerType());
                    hadoopRecord.setPaymentMethod(maskedInvoice.getPaymentMethod());
                    hadoopRecord.setDeliveryType(maskedInvoice.getDeliveryType());
                    hadoopRecord.setCity(maskedInvoice.getCity());
                    hadoopRecord.setState(maskedInvoice.getState());
                    hadoopRecord.setPinCode(maskedInvoice.getPinCode());

                    hadoopRecord.setItemCode(lineItem.getItemCode());
                    hadoopRecord.setDescription(lineItem.getDescription());
                    hadoopRecord.setPrice(lineItem.getPrice());
                    hadoopRecord.setQuantity(lineItem.getQuantity());
                    hadoopRecord.setTotalValue(lineItem.getTotalValue());
                    return hadoopRecord;
                }).collect(Collectors.toList())
        );
        hadoopRecordKStream.to(AppConfigs.hadoopTopic, Produced.with(stringSerde, hadoopRecordSerde));

        /* Set up and start streaming topology */
        KafkaStreams streams = new KafkaStreams(streamsBuilder.build(), properties);
        streams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down stream");
            streams.close();
        }));
    }
}

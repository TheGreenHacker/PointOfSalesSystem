package com.jack.li.kafka.projects;

import com.jack.li.kafka.projects.serde.AppSerdes;
import com.jack.li.kafka.projects.types.POSInvoice;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;

public class POSValidator {
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(StreamsConfig.APPLICATION_ID_CONFIG, AppConfigs.applicationID);
        properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootstrapServers);

        Serde<String> stringSerde = Serdes.String();
        Serde<POSInvoice> posInvoiceSerde = AppSerdes.PosInvoice();
        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String, POSInvoice> posInvoiceKStream = streamsBuilder.stream(AppConfigs.posTopic,
                Consumed.with(stringSerde, posInvoiceSerde));

        /* Filter out invalid invoices, which are those with DeliveryType = "HOME-DELIVERY" and empty ContactNumber */
        KStream<String, POSInvoice> validPOSInvoiceKStream = posInvoiceKStream.filter(
                (storeID, invoice) -> invoice.getDeliveryType().equals("TAKEAWAY") ||
                        !invoice.getDeliveryAddress().getContactNumber().isEmpty()
        );
        validPOSInvoiceKStream.to(AppConfigs.validPOSTopic, Produced.with(stringSerde, posInvoiceSerde));

        /* Set up and start streaming topology */
        KafkaStreams streams = new KafkaStreams(streamsBuilder.build(), properties);
        streams.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down stream");
            streams.close();
        }));
    }
}

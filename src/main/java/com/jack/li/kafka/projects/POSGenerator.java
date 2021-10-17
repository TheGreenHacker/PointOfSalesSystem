package com.jack.li.kafka.projects;

import com.jack.li.kafka.projects.datagenerator.InvoiceGenerator;
import com.jack.li.kafka.projects.serde.JSONSerializer;
import com.jack.li.kafka.projects.types.POSInvoice;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class POSGenerator {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ProducerConfig.CLIENT_ID_CONFIG, AppConfigs.applicationID);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConfigs.bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JSONSerializer.class);

        KafkaProducer<String, POSInvoice> producer = new KafkaProducer<>(props);
        InvoiceGenerator invoiceGenerator = InvoiceGenerator.getInstance();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println("Closing producer.");
                producer.close();
            }
        });

        while (true) {
            POSInvoice posInvoice = invoiceGenerator.getNextInvoice();
            System.out.println("StoreID is " + posInvoice.getStoreID());
            System.out.println("PosID is " + posInvoice.getPosID());
            System.out.println("Delivery type is " + posInvoice.getDeliveryType());
            System.out.println("Delivery address is " + posInvoice.getDeliveryAddress());
            System.out.println("--------------");
            producer.send(new ProducerRecord<>(AppConfigs.posTopic, posInvoice.getStoreID(), posInvoice));
        }
    }
}

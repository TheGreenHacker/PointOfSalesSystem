package com.jack.li.kafka.projects;

public class AppConfigs {
    public final static Double loyaltyRate = 0.05;
    public final static String applicationID = "POSSystem";
    public final static String bootstrapServers = "localhost:9092";
    public final static String posTopic = "pos";
    public final static String validPOSTopic = "valid-pos";
    public final static String shipmentTopic = "shipment";
    public final static String loyaltyTopic = "loyalty";
    public final static String hadoopTopic = "hadoop";
    public final static String groupID = "POSValidator";
    public final static String[] subscribedTopics = {"pos"};
}

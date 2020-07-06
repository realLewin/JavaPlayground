package com.lewin.playground.kafka.demo;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;


public class ConsumerOne {
    //create logger;
    private static final Logger logger = LoggerFactory.getLogger(ConsumerOne.class);

    public static void main(String[] args) {
        String server = "127.0.0.1:9092";
        Properties properties = new Properties();
        String groupID = "first_app";

        //create consumer properties;
        String topic = "test";
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupID);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        //create consumer;
        KafkaConsumer<String, String> consumerOne = new KafkaConsumer<>(properties);
        //subscribing;
        consumerOne.subscribe(Arrays.asList(topic));
        //polling for new data;
        while (true) {
            ConsumerRecords<String, String> records = consumerOne.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                logger.info("Key: " + record.key() +
                        "Value: " + record.value() +
                        "Partition: " + record.partition() +
                        "Offset: " + record.offset());
            }
        }
    }
}











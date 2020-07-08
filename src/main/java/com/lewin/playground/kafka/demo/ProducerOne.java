package com.lewin.playground.kafka.demo;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class ProducerOne {
    private static final Logger logger = LoggerFactory.getLogger(ProducerOne.class);
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //creating properties;
        String bootstrapServer = "127.0.0.1:9092";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //creating producer;
        KafkaProducer<String, String> producerOne = new KafkaProducer<>(properties);
        for(int i = 0; i < 10; i++){
            String topic = "test";
            String value = "Hello from ProducerOne: " + Integer.toString(i);
            String key = "id_" + Integer.toString(i);

            //creating producer record;(with key - it's optional);
            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, value);
            logger.info("key is: " + key);

            //sending the data(with callback - it's optional);
            producerOne.send(record,new Callback(){
                @Override
                public void onCompletion(RecordMetadata metadata, Exception e){
                    if(e == null){
                        logger.info("successfully received the details as: " +
                                "\nTopic: " + metadata.topic() +
                                "\nPartition: " + metadata.partition() +
                                "\nOffset: " + metadata.offset() +
                                "\nTimestamp: " + metadata.timestamp());
                    }else{
                        logger.error("Can't produce, getting error");
                    }
                }
            }).get();
        }

        producerOne.flush();
        producerOne.close();
    }
}

package com.myapp.kafka_consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "customerTopic6", groupId = "cust-group", topicPartitions = {@TopicPartition(topic = "customerTopic6", partitions = {"2"})})
    public void consume(String message) {
        log.info("consumer consume the message {} ",message);
    }
}

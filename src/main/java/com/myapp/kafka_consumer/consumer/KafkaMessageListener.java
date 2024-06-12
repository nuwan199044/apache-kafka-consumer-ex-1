package com.myapp.kafka_consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "customerTopic", groupId = "cust-group-1")
    public void consume(String message) {
        log.info("consumer consume the message {} ",message);
    }
}

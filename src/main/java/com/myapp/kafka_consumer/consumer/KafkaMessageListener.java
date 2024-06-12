package com.myapp.kafka_consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "assetTopic", groupId = "asset-group")
    public void consume1(String message) {
        log.info("consumer1 consume the item {} ",message);
    }

    @KafkaListener(topics = "assetTopic", groupId = "asset-group")
    public void consume2(String message) {
        log.info("consumer2 consume the item {} ",message);
    }

    @KafkaListener(topics = "assetTopic", groupId = "asset-group")
    public void consume3(String message) {
        log.info("consumer3 consume the item {} ",message);
    }

    @KafkaListener(topics = "assetTopic", groupId = "asset-group")
    public void consume4(String message) {
        log.info("consumer4 consume the item {} ",message);
    }
}

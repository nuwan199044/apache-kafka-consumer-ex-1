package com.myapp.consumer;

import com.myapp.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "customerTopic4", groupId = "cust-group")
    public void consume(Customer customer) {
        log.info("consumer consume the message {} ",customer.toString());
    }
}

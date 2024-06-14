package com.myapp.kafka_consumer.consumer;

import com.myapp.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "employeeTopic-avro-1", groupId = "employee-group-avro")
    public void consume(ConsumerRecord<String, Employee> consumerRecord) {
        String key = consumerRecord.key();
        Employee value = consumerRecord.value();
        log.info("Avro message received for key: {} and value: {}",key, value.toString());
    }
}

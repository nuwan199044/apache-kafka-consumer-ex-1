package com.myapp.kafka_consumer;

import com.myapp.dto.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.time.Duration;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@Slf4j
class KafkaConsumerApplicationTests {

	@Container
	static KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));

	@DynamicPropertySource
	public static void initKafkaProperties(DynamicPropertyRegistry registry) {
		registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
	}

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	@Test
	public void testConsume() {
		log.info("testConsume method execution started...");
		Customer customer = new Customer(1, "test user", "test@gmail.com", "714245557");
		kafkaTemplate.send("customerTopic4", customer);
		log.info("testConsumeEvents method execution ended...");
		await().pollInterval(Duration.ofSeconds(3)).atMost(10, SECONDS).untilAsserted(() -> {

		});
	}

}

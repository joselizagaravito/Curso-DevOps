package com.grupo04.account.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaProducer {
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	//private final String kafkaTopic = "tValidacion";

	public void sendMessage(String topic, String message) {
		log.info("Producing message from account {}", message);
		this.kafkaTemplate.send(topic, message);
	}

}

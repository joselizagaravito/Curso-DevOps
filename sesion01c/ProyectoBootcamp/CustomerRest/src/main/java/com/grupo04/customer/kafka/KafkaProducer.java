package com.grupo04.customer.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaProducer {

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	//private final String kafkaTopic = "tOrdenPago";
	
	public void sendMessage(String topic, String purchase) {
		log.info("Enviando orden de pago {}", purchase.toString());
		System.out.println("Enviando orden de pago " + purchase.toString());
		this.kafkaTemplate.send(topic, purchase);
	}
	
}
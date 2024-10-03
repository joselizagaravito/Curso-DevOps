package com.grupo04.account.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.grupo04.account.kafka.KafkaProducer;
import com.grupo04.account.models.PurchaseValidation;


@Component
public class KafkaConsumer {

	@Autowired
	private KafkaProducer producer;
	
	private PurchaseValidation validation;
	
	@KafkaListener(topics = "tTransaction", groupId = "group01", containerFactory = "purchaseRequestListener")
	public void consume(String message) {
		System.out.println("Consumiendo desde tTransaction string: " + message);
		//Validar si tiene cuenta en el banco

		producer.sendMessage("tValidacion", validation.toString());
	}
}
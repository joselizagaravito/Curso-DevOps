package com.grupo04.customer.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
//private PurchaseRequest purchase;
	
	@KafkaListener(topics = "tOrdenPago", groupId = "group01", containerFactory = "purchaseRequestListener")
	public void consume(String message) {
		System.out.println("Consumiendo de orde de pago: " + message);
		
		// Registrar transaccion completada
		
	}
}
package com.grupo04.customer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.grupo04.customer.kafka.KafkaProducer;
import com.grupo04.customer.models.PurchaseRequest;
import com.grupo04.customer.repository.PurchaseRepository;

@Component
public class KafkaConsumer {

	@Autowired
	PurchaseRepository repository;
	
	PurchaseRequest purchase;

	@Autowired
	private KafkaProducer producer;
	

	@KafkaListener(topics = "tSolicitud", groupId = "group01", containerFactory = "purchaseRequestListener")
	public void consumeSolicitud(String topic, String message) {
		System.out.println("Consumiendo desde tSolicitud string: " + message);
		//Guardar solicitud
		repository.save(purchase);
		
		//producer.sendMessage("tTransaction",purchase.toString());
	}
	
	@KafkaListener(topics = "tValidacion", groupId = "group01", containerFactory = "purchaseRequestListener")
	public void consumeValidacion(String topic, String message) {
		System.out.println("Consumiendo desde tValidacion string: " + message);
		
		// Validar disponibilidad de saldo del comprador
		// Emitir orden de pago
		// Actualizar la solicitud
		
		producer.sendMessage(topic,purchase.toString());
	}
}
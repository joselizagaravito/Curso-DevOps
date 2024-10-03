package com.grupo04.customer.controllers;

import com.grupo04.customer.kafka.KafkaProducer;
import com.grupo04.customer.models.PurchaseRequest;
import com.grupo04.customer.service.IPurchaseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/PurchaseRequest")
public class PurchaseRestController {
	private static final Logger log = LoggerFactory.getLogger(PurchaseRestController.class);
	@Autowired
	private IPurchaseService service;

	@Autowired
	private KafkaProducer producer;

	@GetMapping
	public Flux<PurchaseRequest> listar(Model model) {
		log.info("lista de solicitudes de compra");
		return service.findAll();
	}

	@GetMapping("/dni/{dni}")
	public Mono<PurchaseRequest> findByPaymentAmount(@PathVariable float dni) {
		return service.findByPaymentAmount(dni).next();
	}

	@GetMapping("/{id}")
	public Mono<ResponseEntity<PurchaseRequest>> detail(@PathVariable String id) {
		return service.findById(id).map(p -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(p))
				.defaultIfEmpty(
						ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new PurchaseRequest()));
	}

	@PutMapping("/aceptarintercambio/{id}")
	public Mono<ResponseEntity<PurchaseRequest>> edit(@RequestBody PurchaseRequest purchase, @PathVariable String id) {
		// Se genera nuevo numero de transaccion
		purchase.setNumtransaction(LocalDate.now().getYear() * 1000000 + LocalDate.now().getMonthValue() * 10000
				+ LocalDate.now().getDayOfMonth() * 100 + id);
		producer.sendMessage("tTransaction",purchase.toString());
		System.out.println("Actualizando solicitud desde customer " + purchase.toString());
		return service.findById(id).flatMap(p -> {
			return service.save(purchase);
		}).map(p -> ResponseEntity.created(URI.create("/api/purchasepequest".concat(p.getId().toString())))
				.contentType(MediaType.APPLICATION_JSON).body(p)).defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<Void>> edit(@PathVariable String id) {
		return service.findById(id).flatMap(p -> {
			return service.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
		}).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
	}

}

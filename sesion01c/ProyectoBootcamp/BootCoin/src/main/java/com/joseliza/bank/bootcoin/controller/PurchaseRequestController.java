package com.joseliza.bank.bootcoin.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseliza.bank.bootcoin.kafka.KafkaProducer;
import com.joseliza.bank.bootcoin.models.PurchaseRequest;
import com.joseliza.bank.bootcoin.service.PurchaseRequestService;

@RestController
@RequestMapping("/compra")
public class PurchaseRequestController {

	@Autowired
	private KafkaProducer producer;

	@Autowired
	PurchaseRequestService service;

	public PurchaseRequestController(KafkaProducer producer) {
		this.producer = producer;
	}

	@GetMapping
	public List<PurchaseRequest> listar() {
		return service.findAll();
	}

	@GetMapping("/buscarporid/{id}")
	public Optional<PurchaseRequest> detail(@PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping("/buscorporcuenta/{numaccount}")
	public List<PurchaseRequest> findByNumaccount(@PathVariable String numaccount) {
		return service.findByNumaccount(numaccount);
	}

	@GetMapping("/buscorporcell/{cell}")
	public List<PurchaseRequest> findByCell(@PathVariable String cell) {
		return service.findByCell(cell);
	}

	@PostMapping("/solicitar")
	public ResponseEntity<Map<String, Object>> create(@RequestBody PurchaseRequest purchaseRequest) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("Transaccion", "Solicitud");
		result.put("mensaje", "Solicitud enviada para evaluación");
		PurchaseRequest purchasesave = service.save(purchaseRequest);
		result.put("solicitud", purchasesave.toString());
		producer.sendMessage(purchasesave);
		System.out.println("Enviando purchaserequest desde Bootcoin: " + purchasesave);
		return ResponseEntity.created(URI.create("/compra/buscarporid/".concat(purchasesave.getId().toString())))
				.contentType(MediaType.APPLICATION_JSON).body(result);
	}

}

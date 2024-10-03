package com.grupo04.customer.service;

import com.grupo04.customer.models.PurchaseRequest;
import com.grupo04.customer.repository.PurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PurchaseService implements IPurchaseService {
	@Autowired
	private PurchaseRepository repository;

	@Override
	public Flux<PurchaseRequest> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<PurchaseRequest> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Flux<PurchaseRequest> findByCell(String cell) {
		return repository.findByCell(cell);
	}

	@Override
	public Mono<PurchaseRequest> save(PurchaseRequest purchaseRequest) {
		return repository.save(purchaseRequest);
	}

	@Override
	public Mono<Void> delete(PurchaseRequest purchaseRequest) {
		return repository.delete(purchaseRequest);
	}

	@Override
	public Flux<PurchaseRequest> findByPaymentAmount(float amount) {
		return repository.findByPaymentAmount(amount);
	}
}

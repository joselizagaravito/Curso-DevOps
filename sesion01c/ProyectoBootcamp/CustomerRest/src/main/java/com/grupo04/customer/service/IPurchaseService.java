package com.grupo04.customer.service;

import com.grupo04.customer.models.PurchaseRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPurchaseService {
    public Flux<PurchaseRequest> findAll();
    public Flux<PurchaseRequest> findByCell(String cell);
    public Flux<PurchaseRequest> findByPaymentAmount(float paymentAmount);
    public Mono<PurchaseRequest> save(PurchaseRequest purchase);
    public Mono<Void> delete(PurchaseRequest purchase);
	public Mono<PurchaseRequest> findById(String id);
}

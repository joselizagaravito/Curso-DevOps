package com.grupo04.customer.repository;

import com.grupo04.customer.models.PurchaseRequest;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PurchaseRepository extends ReactiveMongoRepository<PurchaseRequest,String> {
    Flux<PurchaseRequest> findByPaymentAmount(float paymentAmount);
    Flux<PurchaseRequest> findByNumaccount(float numaccount);
    Flux<PurchaseRequest> findByCell(String cell);
}

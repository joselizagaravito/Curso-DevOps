package com.joseliza.bank.bootcoin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseliza.bank.bootcoin.models.PurchaseRequest;

public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequest, Long>{
	public List<PurchaseRequest> findByNumaccount(String numaccount);
	public List<PurchaseRequest> findByCell(String cell);
}

package com.joseliza.bank.bootcoin.service;

import java.util.List;
import java.util.Optional;

import com.joseliza.bank.bootcoin.models.PurchaseRequest;


public interface IPurchaseRequestService {

	    public List<PurchaseRequest> findAll();
	    public Optional<PurchaseRequest> findById(Long id);
	    public PurchaseRequest update(PurchaseRequest exchangeRate);
	    public PurchaseRequest save(PurchaseRequest exchangeRate);
	    public void delete(PurchaseRequest exchangeRate);
	    public PurchaseRequest findPurchaseRequestById(Long id);
		public List<PurchaseRequest> findByNumaccount(String numaccount);
		public List<PurchaseRequest> findByCell(String cell);
}
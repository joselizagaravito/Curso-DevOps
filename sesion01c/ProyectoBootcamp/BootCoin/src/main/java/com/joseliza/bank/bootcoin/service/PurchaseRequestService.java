package com.joseliza.bank.bootcoin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.joseliza.bank.bootcoin.config.CacheConfig;
import com.joseliza.bank.bootcoin.models.PurchaseRequest;
import com.joseliza.bank.bootcoin.repository.PurchaseRequestRepository;

@Service
public class PurchaseRequestService implements IPurchaseRequestService {
	@Autowired
	private PurchaseRequestRepository repository;

	@Override
	public List<PurchaseRequest> findAll() {
		return repository.findAll();
	}

	@Override
	public PurchaseRequest save(PurchaseRequest exchangeRate) {
		return repository.save(exchangeRate);
	}

	@Override
	public void delete(PurchaseRequest wallet) {
		repository.delete(wallet);
	}

	@Override
	public Optional<PurchaseRequest> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Cacheable(cacheNames = CacheConfig.USER_CACHE, unless = "#result == null")
	public PurchaseRequest findPurchaseRequestById(Long id) {
		System.out.println("id" + id);
		return repository.findById(id).orElse(null);
	}

	@Override
	public PurchaseRequest update(PurchaseRequest wallet) {
		return repository.save(wallet);
	}

	@Override
	public List<PurchaseRequest> findByCell(String cell) {
		return findByCell(cell);
	}
	@Override

	public List<PurchaseRequest> findByNumaccount(String numaccount){
		return findByNumaccount(numaccount);		
	}
}

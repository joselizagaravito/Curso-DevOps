package com.joseliza.bank.bootcoin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.joseliza.bank.bootcoin.config.CacheConfig;
import com.joseliza.bank.bootcoin.models.TransactionBootCoin;
import com.joseliza.bank.bootcoin.repository.TransactionBootCoinRepository;

@Service
public class TransactionBootCoinService implements ITransactionBootCoinService {
	@Autowired
	private TransactionBootCoinRepository repository;

	@Override
	public List<TransactionBootCoin> findAll() {
		return repository.findAll();
	}

	@Override
	public TransactionBootCoin save(TransactionBootCoin transactionBootCoin) {
		return repository.save(transactionBootCoin);
	}

	@Override
	public void delete(TransactionBootCoin transactionBootCoin) {
		repository.delete(transactionBootCoin);
	}

	@Override
	public Optional<TransactionBootCoin> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Cacheable(cacheNames = CacheConfig.USER_CACHE, unless = "#result == null")
	public TransactionBootCoin findTransactionBootCoinById(Long id) {
		System.out.println("id" + id);
		return repository.findById(id).orElse(null);
	}

	@Override
	public TransactionBootCoin update(TransactionBootCoin wallet) {
		return repository.save(wallet);
	}
}

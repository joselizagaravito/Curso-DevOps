package com.joseliza.bank.bootcoin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.joseliza.bank.bootcoin.config.CacheConfig;
import com.joseliza.bank.bootcoin.models.ExchangeRate;
import com.joseliza.bank.bootcoin.repository.ExchangeRateRepository;

@Service
public class ExchangeRateService implements IExchangeRateService {
	@Autowired
	private ExchangeRateRepository repository;

	@Override
	public List<ExchangeRate> findAll() {
		return repository.findAll();
	}

	@Override
	public ExchangeRate save(ExchangeRate exchangeRate) {
		return repository.save(exchangeRate);
	}

	@Override
	public void delete(ExchangeRate wallet) {
		repository.delete(wallet);
	}

	@Override
	public Optional<ExchangeRate> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Cacheable(cacheNames = CacheConfig.USER_CACHE, unless = "#result == null")
	public ExchangeRate findExchangeRateById(Long id) {
		System.out.println("id" + id);
		return repository.findById(id).orElse(null);
	}

	@Override
	public ExchangeRate update(ExchangeRate wallet) {
		return repository.save(wallet);
	}

	@Override
	public List<ExchangeRate> findByDate(String date) {
		return findByDate(date);
	}
}

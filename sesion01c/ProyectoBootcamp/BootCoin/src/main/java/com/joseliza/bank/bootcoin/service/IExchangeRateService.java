package com.joseliza.bank.bootcoin.service;

import java.util.List;
import java.util.Optional;

import com.joseliza.bank.bootcoin.models.ExchangeRate;


public interface IExchangeRateService {

	    public List<ExchangeRate> findAll();
	    public Optional<ExchangeRate> findById(Long id);
	    public ExchangeRate update(ExchangeRate exchangeRate);
	    public ExchangeRate save(ExchangeRate exchangeRate);
	    public void delete(ExchangeRate exchangeRate);
	    public ExchangeRate findExchangeRateById(Long id);
		public List<ExchangeRate> findByDate(String date);
}
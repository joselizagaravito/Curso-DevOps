package com.joseliza.bank.bootcoin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseliza.bank.bootcoin.models.ExchangeRate;

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long>{
	public List<ExchangeRate> findByDate(String date);
}

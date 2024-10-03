package com.joseliza.bank.bootcoin.service;

import java.util.List;
import java.util.Optional;

import com.joseliza.bank.bootcoin.models.TransactionBootCoin;

public interface ITransactionBootCoinService {
	    public List<TransactionBootCoin> findAll();
	    public Optional<TransactionBootCoin> findById(Long id);
	    public TransactionBootCoin update(TransactionBootCoin transactionBootCoin);
	    public TransactionBootCoin save(TransactionBootCoin transactionBootCoin);
	    public void delete(TransactionBootCoin transactionBootCoin);
	    public TransactionBootCoin findTransactionBootCoinById(Long id);
}
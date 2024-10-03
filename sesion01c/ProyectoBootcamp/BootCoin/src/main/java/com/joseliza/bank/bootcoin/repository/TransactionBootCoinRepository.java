package com.joseliza.bank.bootcoin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseliza.bank.bootcoin.models.TransactionBootCoin;

public interface TransactionBootCoinRepository extends JpaRepository<TransactionBootCoin, Long>{
}

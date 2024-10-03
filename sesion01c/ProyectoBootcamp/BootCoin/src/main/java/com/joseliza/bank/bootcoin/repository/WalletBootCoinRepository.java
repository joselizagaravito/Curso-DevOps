package com.joseliza.bank.bootcoin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joseliza.bank.bootcoin.models.WalletBootCoin;


public interface WalletBootCoinRepository extends JpaRepository<WalletBootCoin, Long>{
	public List<WalletBootCoin> findByNumdocument(String numdocument);
}

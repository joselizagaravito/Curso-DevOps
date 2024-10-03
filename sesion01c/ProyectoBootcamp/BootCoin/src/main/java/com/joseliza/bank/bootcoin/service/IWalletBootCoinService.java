package com.joseliza.bank.bootcoin.service;

import java.util.List;
import java.util.Optional;

import com.joseliza.bank.bootcoin.models.WalletBootCoin;


public interface IWalletBootCoinService {

	    public List<WalletBootCoin> findAll();
	    public Optional<WalletBootCoin> findById(Long id);
	    public WalletBootCoin update(WalletBootCoin wallet);
	    public WalletBootCoin save(WalletBootCoin wallet);
	    public void delete(WalletBootCoin WwlletBootCoin);
	    public WalletBootCoin findWalletById(Long id);
	    
}
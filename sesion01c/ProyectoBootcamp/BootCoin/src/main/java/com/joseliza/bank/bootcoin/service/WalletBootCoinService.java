package com.joseliza.bank.bootcoin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.joseliza.bank.bootcoin.config.CacheConfig;
import com.joseliza.bank.bootcoin.models.WalletBootCoin;
import com.joseliza.bank.bootcoin.repository.WalletBootCoinRepository;

@Service
public class WalletBootCoinService implements IWalletBootCoinService {
	@Autowired
	private WalletBootCoinRepository repository;

	@Override
	public List<WalletBootCoin> findAll() {
		return repository.findAll();
	}

	@Override
	public WalletBootCoin save(WalletBootCoin walletBootCoin) {
		return repository.save(walletBootCoin);
	}

	@Override
	public void delete(WalletBootCoin wallet) {
		repository.delete(wallet);
	}

	@Override
	public Optional<WalletBootCoin> findById(Long id) {
		return repository.findById(id);
	}

	
	@Override
    @Cacheable(cacheNames = CacheConfig.USER_CACHE, unless = "#result == null")
	public WalletBootCoin findWalletById(Long id) {
		System.out.println("id"+id);
		return repository.findById(id).orElse(null);
	}

	@Override
	public WalletBootCoin update(WalletBootCoin wallet) {
		return repository.save(wallet);
	}
}

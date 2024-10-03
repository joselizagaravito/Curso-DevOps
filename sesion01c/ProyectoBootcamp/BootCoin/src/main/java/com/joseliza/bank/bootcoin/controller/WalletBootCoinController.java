package com.joseliza.bank.bootcoin.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseliza.bank.bootcoin.models.WalletBootCoin;
import com.joseliza.bank.bootcoin.service.IWalletBootCoinService;


@RestController
@RequestMapping("/walletbootcoin")
public class WalletBootCoinController {

	@Autowired
	IWalletBootCoinService service;

	@GetMapping
	public List<WalletBootCoin> listar(Model model) {
		return service.findAll();
	}

	@GetMapping("/detail/{id}")
	public Optional<WalletBootCoin> detail(@PathVariable Long id) {
		return service.findById(id);
	}

	@PutMapping
	public WalletBootCoin update(@RequestBody WalletBootCoin walletBootCoin) {
		return service.update(walletBootCoin);
	}

	@PostMapping
	public WalletBootCoin create(@RequestBody WalletBootCoin walletBootCoin) {
		return service.save(walletBootCoin);
	}
	
	@DeleteMapping
	public void delete(@RequestBody WalletBootCoin walletBootCoin) {
		service.delete(walletBootCoin);
	}
	
	@GetMapping("/redisdetail/{id}")
	public WalletBootCoin walletforDetail(@PathVariable Long id) {
		return service.findWalletById(id);
	}
}

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

import com.joseliza.bank.bootcoin.models.TransactionBootCoin;
import com.joseliza.bank.bootcoin.service.ITransactionBootCoinService;


@RestController
@RequestMapping("/transacion")
public class TransactionBootCoinController {

	@Autowired
	ITransactionBootCoinService service;

	@GetMapping
	public List<TransactionBootCoin> listar(Model model) {
		return service.findAll();
	}

	@GetMapping("/detail/{id}")
	public Optional<TransactionBootCoin> detail(@PathVariable Long id) {
		return service.findById(id);
	}

	@PutMapping
	public TransactionBootCoin update(@RequestBody TransactionBootCoin transactionBootCoin) {
		return service.update(transactionBootCoin);
	}

	@PostMapping
	public TransactionBootCoin create(@RequestBody TransactionBootCoin transactionBootCoin) {
		return service.save(transactionBootCoin);
	}
	
	@DeleteMapping
	public void delete(@RequestBody TransactionBootCoin transactionBootCoin) {
		service.delete(transactionBootCoin);
	}
	
	@GetMapping("/redisdetail/{id}")
	public TransactionBootCoin findTransactionBootCoinById(@PathVariable Long id) {
		return service.findTransactionBootCoinById(id);
	}
}

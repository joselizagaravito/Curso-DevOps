package com.joseliza.bank.bootcoin.controller;

import java.time.LocalDate;
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

import com.joseliza.bank.bootcoin.models.ExchangeRate;
import com.joseliza.bank.bootcoin.service.IExchangeRateService;


@RestController
@RequestMapping("/tipocambio")
public class ExchangeRateController {

	@Autowired
	IExchangeRateService service;

	@GetMapping
	public List<ExchangeRate> listar(Model model) {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Optional<ExchangeRate> detail(@PathVariable Long id) {
		return service.findById(id);
	}

	@PutMapping
	public ExchangeRate update(@RequestBody ExchangeRate exchangeRate) {
		return service.update(exchangeRate);
	}

	@PostMapping
	public ExchangeRate create(@RequestBody ExchangeRate exchangeRate) {
		return service.save(exchangeRate);
	}
	
	@DeleteMapping
	public void delete(@RequestBody ExchangeRate exchangeRate) {
		service.delete(exchangeRate);
	}
	
	@GetMapping("/exchangeRateById/{id}")
	public ExchangeRate findExchangeRateById(@PathVariable Long id) {
		return service.findExchangeRateById(id);
	}

	@GetMapping("/hoy")
	public List<ExchangeRate> findByDate() {
		return service.findByDate(LocalDate.now().toString());
	}
}

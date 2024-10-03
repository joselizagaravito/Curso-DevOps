package com.joseliza.bank.bootcoin.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "tipocambio")
public class ExchangeRate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "monedaorigen")
	private String originalCurrency; // moneda origen
	@Column(name = "monedadestino")
	private String destinationCurrency; // moneda destino
	@Column(name = "preciocompra")
	private float buy; // precio de compra
	@Column(name = "precioventa")
	private float sell; // precio de venta
	@Column(name = "fecha")
	private LocalDate date; //fecha del tipo de cambio
}

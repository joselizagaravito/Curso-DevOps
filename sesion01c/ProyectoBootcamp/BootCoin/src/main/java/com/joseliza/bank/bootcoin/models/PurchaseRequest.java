package com.joseliza.bank.bootcoin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "solicitudcompra")
@Builder(toBuilder = true)
public class PurchaseRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numtransaccion")
	private String numtransaction;
	
    @Range(min = 1, message = "Ingrese un monto valido")
	@Column(name = "montopago")
	private float paymentAmount; // monto de pago
    
	@Column(name = "mediopago")
	private String paymentSource; // medio de pago (yanki, transferencia)

	@Size(min = 9, max = 12)
	@Column(name = "numerocuenta")
	private String numaccount; // numero de cuenta de ahorros
	
	@Column(name = "celular")
	private String cell; // numero de cuenta de ahorros
	}

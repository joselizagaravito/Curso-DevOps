package com.joseliza.bank.bootcoin.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TransactionBootCoin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "comprador")
	private String customerBuyer; //comprador de bootcoin
	@Column(name = "vendedor")
	private String customerSeller; //cliente vendedor de bootcoin
	@Column(name = "montopago")
	private float paymentAmount; //monto de pago
	@Column(name = "mediopago")
	private String paymentSource; //medio de pago (yanki, transferencia)
	@Column(name = "cuentapagoid")
	private Long accountPaymentId; //id de la cuenta o monedero yanki
	@Column(name = "mediocobro")
	private String paymentTargetId; //medio de cobro (yanki, cuentaAhorro, cuentaCorriente)
	@Column(name = "cuentacobroid")
	private Long accountTargetId; //id de la cuenta del vendedor donde se abona 
	@Column(name = "datoscompradorok")
	private Boolean validationBuyer; //validar los datos de la compra
	@Column(name = "datosvendedorok")
	private Boolean validationSeller; //resultado de validar si el vendedor tiene monedero yanki o cuenta corriente en el banco
}

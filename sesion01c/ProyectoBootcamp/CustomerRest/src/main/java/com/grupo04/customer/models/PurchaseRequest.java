package com.grupo04.customer.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "solicitudes")
public class PurchaseRequest {
	@Id
	private String id;
	private String numtransaction;
	private float paymentAmount;
	private String paymentSource;
	private String numaccount;
	private String cell;
}

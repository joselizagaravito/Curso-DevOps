package com.joseliza.bank.bootcoin.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="walletbootcoin")
public class WalletBootCoin implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String numdocument;
    private String cell;
    private String email;
    private String accountid;
    private float amountavailable;
    
    private static final long serialVersionUID = 1L;
}

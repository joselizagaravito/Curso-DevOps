package com.joseliza.bank.bootcoin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class BootCoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootCoinApplication.class, args);
	}

}

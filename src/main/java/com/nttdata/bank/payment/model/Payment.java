package com.nttdata.bank.payment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "payments")
public class Payment {

	@Id
	private String _id;
	
	private String description;
	
	private Double amount;
	
	private int externalMobile;
	
	private int mobile;
	
	private Byte type;
	
}
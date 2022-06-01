package com.nttdata.bank.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bank.payment.model.Payment;
import com.nttdata.bank.payment.service.PaymentService;

import reactor.core.publisher.Mono;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping
	public Mono<Payment> save(@RequestBody Payment payment){
		return paymentService.save(payment);
	}

}

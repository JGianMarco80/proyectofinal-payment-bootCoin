package com.nttdata.bank.payment.service;

import com.nttdata.bank.payment.model.Payment;

import reactor.core.publisher.Mono;

public interface PaymentService {

	Mono<Payment> save(Payment payment);
	
}

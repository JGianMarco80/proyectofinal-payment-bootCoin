package com.nttdata.bank.payment.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bank.payment.model.Payment;

@Repository
public interface PaymentRepository extends ReactiveMongoRepository<Payment, String>{

}

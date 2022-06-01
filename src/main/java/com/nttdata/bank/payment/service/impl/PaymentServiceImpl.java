package com.nttdata.bank.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bank.payment.model.Payment;
import com.nttdata.bank.payment.repository.PaymentRepository;
import com.nttdata.bank.payment.service.PaymentService;

import reactor.core.publisher.Mono;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	final static Double tasaVenta = 3.725;
	final static Double tasaCompra = 3.690;
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Mono<Payment> save(Payment payment) {
		Double bootCoint = payment.getAmount();
		return Mono.just(payment)
				.flatMap(p -> {
						Payment payment1 = new Payment();
						payment1.setDescription("Compraste BootCoint");
						payment1.setMobile(p.getMobile());
						payment1.setExternalMobile(p.getExternalMobile());
						payment1.setAmount(bootCoint * tasaCompra);
						payment1.setType((byte) 1);
					return paymentRepository.save(payment1)
							.flatMap(pa -> {
								Payment payment2 = new Payment();
								payment2.setDescription("Vendiste BootCoint");
								payment2.setMobile(pa.getExternalMobile());
								payment2.setExternalMobile(pa.getMobile());
								payment2.setAmount(bootCoint * tasaVenta);
								payment2.setType((byte) 1);
								return paymentRepository.save(payment2)
										.flatMap(pay -> {
											Payment payment3 = new Payment();
											payment3.setDescription("BootCoint vendidas");
											payment3.setMobile(pa.getExternalMobile());
											payment3.setExternalMobile(pa.getMobile());
											payment3.setAmount(bootCoint);
											payment3.setType((byte) 2);
											return paymentRepository.save(payment3)
													.flatMap(paym -> {
														Payment payment4 = new Payment();
														payment4.setDescription("BootCoint compradas");
														payment4.setMobile(p.getMobile());
														payment4.setExternalMobile(p.getExternalMobile());
														payment4.setAmount(bootCoint);
														payment4.setType((byte) 2);
														return paymentRepository.save(payment4);
													});
										});
							});
				});
	}

}

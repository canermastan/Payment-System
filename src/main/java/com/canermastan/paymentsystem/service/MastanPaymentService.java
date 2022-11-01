package com.canermastan.paymentsystem.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canermastan.paymentsystem.entity.Payment;
import com.canermastan.paymentsystem.repository.PaymentRepository;
import com.canermastan.paymentsystem.service.bank.BankPaymentRequest;
import com.canermastan.paymentsystem.service.bank.BankPaymentResponse;
import com.canermastan.paymentsystem.service.bank.BankService;

@Service
public class MastanPaymentService {
	private Logger logger = LoggerFactory.getLogger(MastanPaymentService.class);

	private BankService bankService;
	private PaymentRepository paymentRepository;

	public MastanPaymentService(BankService bankService, PaymentRepository paymentRepository) {
		this.bankService = bankService;
		this.paymentRepository = paymentRepository;
	}

	@Transactional
	public void pay(BigDecimal price, Long cardId) {
		// pay with bank
		BankPaymentRequest request = new BankPaymentRequest();
		request.setPrice(price);
		BankPaymentResponse response = bankService.pay(request);

		// insert records
		Payment payment = new Payment();
		payment.setBankResponse(response.getResultCode());
		payment.setPrice(price);
		payment.setCardId(cardId);
		paymentRepository.save(payment);
		logger.info("Payment saved successfully!");
	}

}

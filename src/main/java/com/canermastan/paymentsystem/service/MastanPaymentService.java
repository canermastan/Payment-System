package com.canermastan.paymentsystem.service;

import java.math.BigDecimal;

import com.canermastan.paymentsystem.entity.dto.CreditCardDto;
import org.apache.commons.codec.digest.DigestUtils;
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
	private CreditCardService creditCardService;
	private PaymentRepository paymentRepository;

	public MastanPaymentService(BankService bankService, CreditCardService creditCardService, PaymentRepository paymentRepository) {
		this.bankService = bankService;
		this.creditCardService = creditCardService;
		this.paymentRepository = paymentRepository;
	}

	@Transactional
	public void pay(BigDecimal price, CreditCardDto creditCardDto) throws Exception {
		// pay with bank
		BankPaymentRequest request = new BankPaymentRequest(price, creditCardDto);
		BankPaymentResponse response = bankService.pay(request);

		// insert records
		Payment payment = new Payment();
		payment.setBankResponse(response.getResultCode());
		payment.setCardId(creditCardService.findByNumber(creditCardDto.getNumber()).getId());
		payment.setPrice(price);
		// payment.setCardNumber(cardNumber);
		paymentRepository.save(payment);
		logger.info("Payment saved successfully!");
	}

}

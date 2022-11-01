package com.canermastan.paymentsystem.api.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canermastan.paymentsystem.core.results.DataResult;
import com.canermastan.paymentsystem.core.results.SuccessDataResult;
import com.canermastan.paymentsystem.entity.dto.ProductPaymentDto;
import com.canermastan.paymentsystem.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public DataResult<Object> payment(@Valid @RequestBody ProductPaymentDto productPaymentDto) throws Exception{
    	return new SuccessDataResult<>(paymentService.payment(productPaymentDto).join());
    }
}

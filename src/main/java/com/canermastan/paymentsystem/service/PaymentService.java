package com.canermastan.paymentsystem.service;

import java.util.concurrent.CompletableFuture;

import com.canermastan.paymentsystem.entity.dto.ProductPaymentDto;

public interface PaymentService {
	CompletableFuture<String> payment(ProductPaymentDto productPaymentDto) throws Exception;
}

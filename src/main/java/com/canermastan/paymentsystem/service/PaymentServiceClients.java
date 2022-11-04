package com.canermastan.paymentsystem.service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

import com.canermastan.paymentsystem.entity.dto.CreditCardDto;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceClients {
    private MastanPaymentService mastanPaymentService;

    public PaymentServiceClients(MastanPaymentService mastanPaymentService) {
        this.mastanPaymentService = mastanPaymentService;
    }

    @Async
    public CompletableFuture<String> call(BigDecimal price, CreditCardDto creditCardDto) throws Exception {
    	mastanPaymentService.pay(price, creditCardDto);
        return CompletableFuture.completedFuture("success");
    }
}

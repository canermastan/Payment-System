package com.canermastan.paymentsystem.service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceClients {
    private MastanPaymentService mastanPaymentService;

    public PaymentServiceClients(MastanPaymentService mastanPaymentService) {
        this.mastanPaymentService = mastanPaymentService;
    }

    @Async
    public CompletableFuture<String> call(BigDecimal price, Long cardId) {
    	mastanPaymentService.pay(price, cardId);
        return CompletableFuture.completedFuture("success");
    }
}

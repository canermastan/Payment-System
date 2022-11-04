package com.canermastan.paymentsystem.service.bank;

import com.canermastan.paymentsystem.entity.dto.CreditCardDto;

import java.math.BigDecimal;

public class BankPaymentRequest {
    private BigDecimal price;

    private CreditCardDto creditCardDto;

    public BankPaymentRequest(){

    }
    public BankPaymentRequest(BigDecimal price, CreditCardDto creditCardDto) {
        this.price = price;
        this.creditCardDto = creditCardDto;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CreditCardDto getCreditCardDto() {
        return creditCardDto;
    }

    public void setCreditCardDto(CreditCardDto creditCardDto) {
        this.creditCardDto = creditCardDto;
    }
}

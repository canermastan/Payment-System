package com.canermastan.paymentsystem.entity.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProductPaymentDto {
	@NotNull
    @Min(1)
    private Long productId;
	
	@NotNull
	private CreditCardDto creditCardDto;

    @Min(1)
    private int quantity;

    public ProductPaymentDto() {

    }

    public ProductPaymentDto(Long productId, CreditCardDto creditCardDto, int quantity) {
        this.productId = productId;
        this.creditCardDto = creditCardDto;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public CreditCardDto getCreditCardDto() {
        return creditCardDto;
    }

    public void setCreditCardDto(CreditCardDto creditCardDto) {
        this.creditCardDto = creditCardDto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

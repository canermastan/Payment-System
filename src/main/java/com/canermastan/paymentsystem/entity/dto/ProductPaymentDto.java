package com.canermastan.paymentsystem.entity.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProductPaymentDto {
	@NotNull
    @Min(1)
    private Long productId;
	
	@NotNull
    @Min(1)
	private Long cardId;

    @Min(1)
    private int quantity;

    public ProductPaymentDto() {

    }
    
    

    public ProductPaymentDto(@NotNull @Min(1) Long productId, @NotNull @Min(1) Long cardId, @Min(1) int quantity) {
		this.productId = productId;
		this.cardId = cardId;
		this.quantity = quantity;
	}



	public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}
    
    
}

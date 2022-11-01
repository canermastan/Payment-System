package com.canermastan.paymentsystem.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {
	public Payment(Long id, Long cardId, BigDecimal price, String bankResponse) {
		this.id = id;
		this.cardId = cardId;
		this.price = price;
		this.bankResponse = bankResponse;
	}
	public Payment() {
		
	}
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Long cardId;
	@Column
	private BigDecimal price;
	@Column
	private String bankResponse;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getBankResponse() {
		return bankResponse;
	}

	public void setBankResponse(String bankResponse) {
		this.bankResponse = bankResponse;
	}
	public Long getCardId() {
		return cardId;
	}
	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}
	
}

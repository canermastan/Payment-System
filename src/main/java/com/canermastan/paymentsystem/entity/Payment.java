package com.canermastan.paymentsystem.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column
	private BigDecimal price;
	@Column
	private String bankResponse;

	@Column(name = "cc_id")
	private Long cardId;

	public Payment(){

	}

	public Payment(Long id, BigDecimal price, String bankResponse, Long cardId) {
		this.id = id;
		this.price = price;
		this.bankResponse = bankResponse;
		this.cardId = cardId;
	}

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

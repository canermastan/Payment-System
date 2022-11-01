package com.canermastan.paymentsystem.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditCard {

	@Id
	@GeneratedValue
	private Long id;
	@Column
	private String number;
	@Column
	private String expMonth;
	@Column
	private String expYear;
	@Column
	private String ccv;
	@Column
	private BigDecimal amount;

	public CreditCard() {

	}

	public CreditCard(Long id, String number, String expMonth, String expYear, String ccv, BigDecimal amount) {
		this.id = id;
		this.number = number;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.ccv = ccv;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	public String getCcv() {
		return ccv;
	}

	public void setCcv(String ccv) {
		this.ccv = ccv;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}

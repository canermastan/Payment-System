package com.canermastan.paymentsystem.entity.dto;

import javax.validation.constraints.NotNull;

public class CreditCardDto {

	@NotNull
	private String number;

	@NotNull
	private String expMonth;

	@NotNull
	private String expYear;
	
	@NotNull
	private String ccv;
	
	public CreditCardDto() {
		
	}

	public CreditCardDto(@NotNull String number, @NotNull String expMonth, @NotNull String expYear,
			@NotNull String ccv) {
		this.number = number;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.ccv = ccv;
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
	
}

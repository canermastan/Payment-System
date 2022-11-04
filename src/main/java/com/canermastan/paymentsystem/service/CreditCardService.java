package com.canermastan.paymentsystem.service;

import java.math.BigDecimal;
import java.util.List;

import com.canermastan.paymentsystem.core.results.DataResult;
import com.canermastan.paymentsystem.core.results.Result;
import com.canermastan.paymentsystem.entity.CreditCard;
import com.canermastan.paymentsystem.entity.dto.CreditCardDto;

public interface CreditCardService {
	DataResult<CreditCard> save(CreditCardDto creditCartDto);
	DataResult<List<CreditCard>> findAll();
	CreditCard findByNumber(String number);
	
	void decreaseAmount(BigDecimal price, String cardNumber);
}

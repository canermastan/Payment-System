package com.canermastan.paymentsystem.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.canermastan.paymentsystem.core.results.DataResult;
import com.canermastan.paymentsystem.core.results.ErrorDataResult;
import com.canermastan.paymentsystem.core.results.Result;
import com.canermastan.paymentsystem.core.results.SuccessDataResult;
import com.canermastan.paymentsystem.entity.CreditCard;
import com.canermastan.paymentsystem.entity.dto.CreditCardDto;
import com.canermastan.paymentsystem.repository.CreditCardRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService{
	
	private final CreditCardRepository creditCardRepository;
	
	public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
		this.creditCardRepository = creditCardRepository;
	}
	
	@Override
	public DataResult<CreditCard> save(CreditCardDto creditCartDto) {
		CreditCard creditCard = new CreditCard();
		creditCard.setCcv(creditCartDto.getCcv());
		creditCard.setExpMonth(creditCartDto.getExpMonth());
		creditCard.setExpYear(creditCartDto.getExpYear());
		creditCard.setNumber(creditCartDto.getNumber());
		
		creditCard.setAmount(BigDecimal.valueOf(8000.0));
		
		return new SuccessDataResult<CreditCard>(creditCardRepository.save(creditCard), "Yeni kart eklendi.");
	}

	@Override
	public DataResult<List<CreditCard>> findAll() {
		return new SuccessDataResult<List<CreditCard>>(creditCardRepository.findAll(), "Tüm kartlar getirildi");
	}

	@Override
	public DataResult<CreditCard> findById(Long id) {
		if(creditCardRepository.findById(id).isPresent()) {
			return new SuccessDataResult<CreditCard>(creditCardRepository.findById(id).get());
		}
		return new ErrorDataResult<CreditCard>("Cart bulunamadı.");
	}

	@Override
	public void decreaseAmount(BigDecimal price, Long cardId) {
		creditCardRepository.decreaseAmount(price, cardId);
	}

}

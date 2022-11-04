package com.canermastan.paymentsystem.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.canermastan.paymentsystem.core.results.SuccessDataResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canermastan.paymentsystem.core.results.DataResult;
import com.canermastan.paymentsystem.entity.CreditCard;
import com.canermastan.paymentsystem.entity.dto.CreditCardDto;
import com.canermastan.paymentsystem.service.CreditCardService;

@RestController
@RequestMapping("/api/cc")
public class CreditCardController {
	
	private final CreditCardService creditCardService;
	
	public CreditCardController(CreditCardService creditCardService) {
		this.creditCardService = creditCardService;
	}
	
	@GetMapping("/get-all")
	public DataResult<List<CreditCard>> findAll(){
		return creditCardService.findAll();
	}
	
	@PostMapping
	public DataResult<CreditCard> save(@Valid @RequestBody CreditCardDto creditCardDto){
		return creditCardService.save(creditCardDto);
	}

	@GetMapping("/{number}")
	public CreditCard findByNumber(@PathVariable String number){
		return creditCardService.findByNumber(number);
	}
}

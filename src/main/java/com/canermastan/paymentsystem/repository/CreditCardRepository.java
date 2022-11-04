package com.canermastan.paymentsystem.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.canermastan.paymentsystem.core.results.Result;
import com.canermastan.paymentsystem.entity.CreditCard;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	@Modifying
	@Transactional
	@Query("UPDATE CreditCard SET amount = amount - :price WHERE number = :cardNumber")
	void decreaseAmount(BigDecimal price, String cardNumber);

	CreditCard findByNumber(String number);
}

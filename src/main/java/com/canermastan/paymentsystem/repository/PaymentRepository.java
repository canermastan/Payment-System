package com.canermastan.paymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canermastan.paymentsystem.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}

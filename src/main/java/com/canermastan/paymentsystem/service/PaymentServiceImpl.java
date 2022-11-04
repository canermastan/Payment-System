package com.canermastan.paymentsystem.service;

import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

import com.canermastan.paymentsystem.exception.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.canermastan.paymentsystem.entity.Product;
import com.canermastan.paymentsystem.entity.dto.ProductPaymentDto;
import com.canermastan.paymentsystem.exception.OutOfStockException;

@Service
public class PaymentServiceImpl implements PaymentService {
	private Logger logger = LoggerFactory.getLogger(MastanPaymentService.class);

	private final PaymentServiceClients paymentServiceClients;
	private final ProductService productService;
	private final CreditCardService creditCardService;

	public PaymentServiceImpl(PaymentServiceClients paymentServiceClients, ProductService productService,
			CreditCardService creditCardService) {
		this.paymentServiceClients = paymentServiceClients;
		this.productService = productService;
		this.creditCardService = creditCardService;
	}

	@Override
	public CompletableFuture<String> payment(ProductPaymentDto productPaymentDto) throws Exception {

		Product product = productService.findById(productPaymentDto.getProductId());

		if(product == null) {
			throw new ProductNotFoundException("Product not found");
		}

		int quantity = productPaymentDto.getQuantity();
		if (!product.checkStockQuantity(quantity)) {
			throw new OutOfStockException("Invalid stock number");
		}

		int currentStock = product.getStock() - quantity;
		try {
			productService.updateStock(product.getId(), currentStock);
			BigDecimal price = product.getPrice().multiply(new BigDecimal(quantity));

			return paymentServiceClients.call(price, productPaymentDto.getCreditCardDto());
		} catch (ObjectOptimisticLockingFailureException opEx) {
			throw new Exception(
					"Optimistic Lock : The record you attempted to edit was modified by another user after you got the original value");
		} catch (Exception ex) {
			throw new Exception("Payment error : " + ex.getMessage());
		}
	}

}

package com.canermastan.paymentsystem.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canermastan.paymentsystem.core.results.DataResult;
import com.canermastan.paymentsystem.core.results.SuccessDataResult;
import com.canermastan.paymentsystem.entity.Product;
import com.canermastan.paymentsystem.entity.dto.ProductPostDto;
import com.canermastan.paymentsystem.exception.ProductAlreadyExistException;
import com.canermastan.paymentsystem.exception.ProductNotFoundException;
import com.canermastan.paymentsystem.repository.ProductRepository;
import com.canermastan.paymentsystem.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	// TODO new işlemini service katmanında yap!
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/get-all")
	public DataResult<List<Product>> findAll() {
		return productService.findAll();
	}

	@PostMapping
	public DataResult<Product> saveNewProduct(@Valid @RequestBody ProductPostDto productPostDto)
			throws ProductAlreadyExistException {
		return productService.save(productPostDto);
	}

	@PutMapping("/{id}")
	public DataResult<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductPostDto productPostDto)
			throws ProductNotFoundException {
		return productService.update(id, productPostDto);
	}
}

package com.canermastan.paymentsystem.service;

import java.util.List;

import com.canermastan.paymentsystem.core.results.DataResult;
import com.canermastan.paymentsystem.entity.Product;
import com.canermastan.paymentsystem.entity.dto.ProductPostDto;
import com.canermastan.paymentsystem.exception.ProductAlreadyExistException;
import com.canermastan.paymentsystem.exception.ProductNotFoundException;

public interface ProductService {
    DataResult<List<Product>> findAll();
    Product findById(Long productId) throws ProductNotFoundException;
    DataResult<Product> save(ProductPostDto productPostDto) throws ProductAlreadyExistException;
    DataResult<Product> update(Long id, ProductPostDto productPostDto) throws ProductNotFoundException;
    Product updateStock(Long productId, int stock) throws ProductNotFoundException;
}

package com.canermastan.paymentsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.canermastan.paymentsystem.core.results.DataResult;
import com.canermastan.paymentsystem.core.results.SuccessDataResult;
import com.canermastan.paymentsystem.entity.Product;
import com.canermastan.paymentsystem.entity.dto.ProductPostDto;
import com.canermastan.paymentsystem.exception.ProductAlreadyExistException;
import com.canermastan.paymentsystem.exception.ProductNotFoundException;
import com.canermastan.paymentsystem.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public DataResult<List<Product>> findAll() {
		return new SuccessDataResult<List<Product>>(productRepository.findAll(), "Tüm Ürünler Getirildi.");
	}

	@Override
	public Product findById(Long productId) throws ProductNotFoundException {
		return productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Record Not Found"));
	}

	@Override
	public DataResult<Product> save(ProductPostDto productPostDto) throws ProductAlreadyExistException {

		if (!checkProductNameIsExist(productPostDto.getName())) {
			throw new ProductAlreadyExistException("The product already exists!");
		}

		Product saveProduct = new Product();
		saveProduct.setName(productPostDto.getName());
		saveProduct.setDescription(productPostDto.getDescription());
		saveProduct.setStock(productPostDto.getStock());
		saveProduct.setPrice(productPostDto.getPrice());
		return new SuccessDataResult<Product>(productRepository.save(saveProduct));
	}

	@Override
	public DataResult<Product> update(Long id, ProductPostDto productPostDto) throws ProductNotFoundException {
		Product updateProduct = this.findById(id);
		updateProduct.setName(productPostDto.getName());
		updateProduct.setDescription(productPostDto.getDescription());
		updateProduct.setPrice(productPostDto.getPrice());
		updateProduct.setStock(productPostDto.getStock());
		return new SuccessDataResult<Product>(productRepository.save(updateProduct), "Ürün Güncellendi");
	}

	@Override
	public Product updateStock(Long productId, int stock) throws ProductNotFoundException {
		Product product = this.findById(productId);
		product.setStock(stock);
		return productRepository.save(product);
	}

	private boolean checkProductNameIsExist(String name) {
		return !productRepository.findByName(name).isPresent();
	}

}

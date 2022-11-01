package com.canermastan.paymentsystem.entity.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class ProductPostDto {
	@NotNull
	private String name;
	@NotNull
	private String description;
	@NotNull
	private int stock;
	@NotNull
	private BigDecimal price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}

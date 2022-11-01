package com.canermastan.paymentsystem.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class Product {
	@Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private int stock;
    private BigDecimal price;
    /*
    * The version column with optimistic lock and hibernate feature was used to check the product
    * stock of users who make purchases at the same time.
    * */
    @Version
    private Long version;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Transient
    public boolean checkStockQuantity(int paymentQuantity){
        return stock > 0 && stock >= paymentQuantity;
    }
}

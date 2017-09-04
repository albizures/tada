/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tada.beans;

import java.math.BigDecimal;

/**
 *
 * @author erick
 */
public class Product {
    private int idProduct;
    private String name;
    private BigDecimal price;
    private int idCategory;
    private String description;
    private int stock;

    public Product() {
    }
    
    public Product(int idProduct, String name, BigDecimal price, int idCategory, String description, int stock) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.idCategory = idCategory;
        this.description = description;
        this.stock = stock;
    }

    public Product(String name, BigDecimal price, int idCategory, String description, int stock) {
        this.name = name;
        this.price = price;
        this.idCategory = idCategory;
        this.description = description;
        this.stock = stock;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
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

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", name=" + name + ", price=" + price + ", idCategory=" + idCategory + ", description=" + description + ", stock=" + stock + '}';
    }
}

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
public class CartItem {
    private String name;
    private BigDecimal price;

    public CartItem() {
    }

    public CartItem(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return "Cart{" + "name=" + name + ", price=" + price + '}';
    }
}

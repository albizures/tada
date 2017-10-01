package com.tada.handlers;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.tada.beans.Product;

public class ProductHandler extends BeanHandler<Product> {

    public ProductHandler() {
        super(Product.class, new ProductRowProcessor());
    }
}
package com.tada.handlers;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tada.beans.Product;

public class ProductListHandler extends BeanListHandler<Product> {

    public ProductListHandler() {
        super(Product.class, new ProductRowProcessor());
    }
}
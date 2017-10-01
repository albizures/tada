package com.tada.beans;

import java.math.BigDecimal;

public class Product {
    private int idProduct;
    private String name;
    private BigDecimal price;
    private Category category;
    private String description;
    private int stock;
    private Image image;

    public Product() {
    }
    
    public Product(int idProduct, String name, BigDecimal price, Category category, String description, int stock, Image image) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.stock = stock;
        this.image = image;
    }
    
    public Product(int idProduct, String name, BigDecimal price, int idCategory, String description, int stock, Image image) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.category = new Category(idCategory);
        this.description = description;
        this.stock = stock;
        this.image = image;
    }
    
    public Product(String name, BigDecimal price, int idCategory, String description, int stock, Image image) {
        this.name = name;
        this.price = price;
        this.category = new Category(idCategory);
        this.description = description;
        this.stock = stock;
        this.image = image;
    }

    public Product(String name, BigDecimal price, Category category, String description, int stock) {
        this.name = name;
        this.price = price;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
    
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
    public boolean isValid () {
        return idProduct > -1;
    }

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", name=" + name + ", price=" + price + ", category=" + category.getName() + ", description=" + description + ", stock=" + stock + '}';
    }
}

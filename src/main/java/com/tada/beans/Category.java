package com.tada.beans;

public class Category {
    private int idCategory = -1;
    private String name;

    public Category(int idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }
    
    public Category(int idCategory) {
        this.idCategory = idCategory;
    }
    
    public Category() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public boolean isValid () {
        return idCategory > -1;
    }

    @Override
    public String toString() {
        return "Category{" + "idCategory=" + idCategory + ", name=" + name + '}';
    }
}

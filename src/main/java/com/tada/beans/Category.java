/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tada.beans;

/**
 *
 * @author erick
 */
public class Category {
    private int idCategory;
    private String name;

    public Category(int idCategory, String name) {
        this.idCategory = idCategory;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Category{" + "idCategory=" + idCategory + ", name=" + name + '}';
    }
}

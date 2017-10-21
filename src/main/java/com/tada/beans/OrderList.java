package com.tada.beans;

public class OrderList {
    private int idOrderList;
    private int idOrder;
    private int idProduct;
    private int quantity;

    public OrderList(int idOrderList, int idOrder, int idProduct, int quantity) {
        this.idOrderList = idOrderList;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public OrderList(int idOrder, int idProduct, int quantity) {
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }
    
    public OrderList(){}
    
    public int getIdOrderList() {
        return idOrderList;
    }

    public void setIdOrderList(int idOrderList) {
        this.idOrderList = idOrderList;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderList{" + "idOrderList=" + idOrderList + ", idOrder=" + idOrder + ", idProduct=" + idProduct + ", quantity=" + quantity + '}';
    }
}

package com.tada.beans;

public class OrderStatus {
    private int idOrderStatus;
    private String name;

    public OrderStatus(int idOrderStatus, String name) {
        this.idOrderStatus = idOrderStatus;
        this.name = name;
    }

    public OrderStatus(String name) {
        this.name = name;
    }

    public int getIdOrderStatus() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(int idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrderStatus{" + "idOrderStatus=" + idOrderStatus + ", name=" + name + '}';
    }
}

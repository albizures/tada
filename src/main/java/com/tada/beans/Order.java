/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tada.beans;

import java.sql.Timestamp;

/**
 *
 * @author erick
 */
public class Order {
    private int idOrder;
    private Timestamp date;
    private int idCard;
    private int idUser;
    private int idOrderStatus;

    public Order(int idOrder, Timestamp date, int idCard, int idUser, int idOrderStatus) {
        this.idOrder = idOrder;
        this.date = date;
        this.idCard = idCard;
        this.idUser = idUser;
        this.idOrderStatus = idOrderStatus;
    }

    public Order(Timestamp date, int idCard, int idUser, int idOrderStatus) {
        this.date = date;
        this.idCard = idCard;
        this.idUser = idUser;
        this.idOrderStatus = idOrderStatus;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getIdCard() {
        return idCard;
    }

    public void setIdCard(int idCard) {
        this.idCard = idCard;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdOrderStatus() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(int idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", date=" + date + ", idCard=" + idCard + ", idUser=" + idUser + ", idOrderStatus=" + idOrderStatus + '}';
    }
}

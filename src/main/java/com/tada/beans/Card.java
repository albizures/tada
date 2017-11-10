package com.tada.beans;

public class Card {
    private int id_card;
    private String name;
    private int number;
    private int month;
    private int year;
    private int id_user;
    public Card(){}
    public Card(int id_card, String name, int number, int month, int year, int id_user) {
        this.id_card = id_card;
        this.name = name;
        this.number = number;
        this.month = month;
        this.year = year;
        this.id_user = id_user;
    }

    public Card(String name, int number, int month, int year, int id_user) {
        this.name = name;
        this.number = number;
        this.month = month;
        this.year = year;
        this.id_user = id_user;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Card{" + "id_card=" + id_card + ", name=" + name + ", number=" + number + ", month=" + month + ", year=" + year + ", id_user=" + id_user + '}';
    }
}

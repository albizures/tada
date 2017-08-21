
package com.tada.umgproject;

import java.sql.ResultSet;

public class User {
    private int idUser;
    private String firstName;
    private String lastName;
    private String address;
    private int phone;
           
    public User (final int idUser, final String firstName, final String lastName, final String address, final int phone) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }
    
    public static User getUserById (int idUser) {
        ResultSet rs = DBConnection.exec("select * from user");
        try {
            if (!rs.next()) {
                return null;
            }
            return new User(
                rs.getInt("id_user"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("address"),
                rs.getInt("phone")
            );
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }        
    }
    
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}

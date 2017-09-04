/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tada.dao;

import com.tada.DBConnection;
import com.tada.beans.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author erick
 */
public class UserDAO {
    public int insert(User user){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_insert = "INSERT INTO user " +
                            "(first_name," +
                            "last_name," +
                            "address," +
                            "phone," +
                            "password) " +
                            "VALUES " +
                            "(?,?,?,?,?)";
        int result = 0;
        try {
            result = qr.update(sql_insert, 
                    user.getFirstName(),
                    user.getLastName(),
                    user.getAddress(),
                    user.getPhone(),
                    user.getPassword());
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return result;
    }
    
    public int update(User user){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_update = "UPDATE user " +
                            "SET " +
                            "first_name = ?," +
                            "last_name = ?," +
                            "address = ?," +
                            "phone = ?," +
                            "password = ? " +
                            "WHERE id_user = ?";
        int result = 0;
        try {
            result = qr.update(sql_update, 
                    user.getFirstName(),
                    user.getLastName(),
                    user.getAddress(),
                    user.getPhone(),
                    user.getPassword(),
                    user.getIdUser());
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return result;
    }
    
    public int delete(int id){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_update = "DELETE FROM user " +
                            "WHERE id_user = ?";
        int result = 0;
        try {
            result = qr.update(sql_update,id);
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return result;
    }
    
    public List<User> list(){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = "SELECT user.id_user," +
                            "user.first_name," +
                            "user.last_name," +
                            "user.address," +
                            "user.phone," +
                            "user.password " +
                            "FROM user";
        ResultSetHandler<List<User>> rlh = new BeanListHandler<>(User.class);
        List<User> list = new ArrayList<>();
        try {
            list = qr.query(sql_select, rlh);
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return list;
    }
    
    public User get(int id){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = "SELECT user.id_user," +
                            "user.first_name," +
                            "user.last_name," +
                            "user.address," +
                            "user.phone," +
                            "user.password" +
                            "FROM user" +
                            "WHERE user.id_user =?";
        ResultSetHandler<User> rsh = new BeanHandler<>(User.class);
        User user = new User();
        try {
            user = qr.query(sql_select, rsh,id);
        } catch(SQLException ex) {
            ex.getMessage();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return user;
    }
}

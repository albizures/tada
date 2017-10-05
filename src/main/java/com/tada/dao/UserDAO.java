package com.tada.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tada.DBConnection;
import com.tada.PropertiesUtil;
import com.tada.beans.User;

public class UserDAO {
    static Properties scripts = PropertiesUtil.getProperties("sql/user.properties");

    public int insert(final User user){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_insert = scripts.getProperty("insert");

        int result = 0;
        try {
            result = qr.update(conn,
                sql_insert, 
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getPhone(),
                user.getPassword(),
                user.getEmail()
            );
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public int update(final User user){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_update = scripts.getProperty("update");
        
        int result = 0;
        try {
            result = qr.update(
                sql_update, 
                user.getFirstName(),
                user.getLastName(),
                user.getAddress(),
                user.getPhone(),
                user.getPassword(),
                user.getIdUser()
            );
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public int delete (final User user) {
        return delete(user.getIdUser());
    }

    public int delete(int id){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_update = scripts.getProperty("delete");

        int result = 0;
        try {
            result = qr.update(sql_update,id);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public List<User> list(){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = scripts.getProperty("select");
        ResultSetHandler<List<User>> rlh = new BeanListHandler<>(User.class);
        List<User> list = new ArrayList<>();
        try {
            list = qr.query(sql_select, rlh);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public User get(final int id){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = scripts.getProperty("select.by.id");

        ResultSetHandler<User> rsh = new BeanHandler<>(User.class);
        User user = new User();
        try {
            user = qr.query(conn, sql_select, rsh,id);
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    public User login(final String email, final String password) {
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = scripts.getProperty("select.by.email.password");

        ResultSetHandler<User> rsh = new BeanHandler<>(User.class);
        User user = new User();
        try {
            user = qr.query(conn, sql_select, rsh, email, password);
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }
}

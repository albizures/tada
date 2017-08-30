/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tada.dao;

import com.tada.DBConnection;
import com.tada.beans.Category;
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
public class CategoryDAO {
    
    public int insert(Category category){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_insert = "INSERT INTO category " +
                            "(name) " +
                            "VALUES(?)";
        int result = 0;
        try {
            result = qr.update(sql_insert, category.getName());
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return result;
    }
    
    public int update(Category category){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_update = "UPDATE tada.category " +
                            "SET name=? " +
                            "WHERE id_category=?";
        int result = 0;
        try {
            result = qr.update(sql_update,
                    category.getName(),
                    category.getIdCategory());
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
        String sql_delete = "DELETE FROM  category " +
                            "WHERE id_category=?";
        int result = 0;
        try {
            result = qr.update(sql_delete,id);
        } catch (SQLException ex){
            ex.getMessage();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return result;
    }
    
    public List<Category> list(){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = "SELECT id_category, name " +
                            "FROM category";
        ResultSetHandler<List<Category>> rlh = new BeanListHandler<>(Category.class);
        List<Category> list = new ArrayList<>();
        try {
            list = qr.query(sql_select, rlh);
        } catch (SQLException ex){
            ex.getMessage();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return list;
    }
    
    public Category get(int id){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = "SELECT id_category, name " +
                            "FROM category " +
                            "WHERE id_category=?";
        ResultSetHandler<Category> rsh = new BeanHandler<>(Category.class);
        Category category = new Category();
        try {
            category = qr.query(sql_select,rsh,id);
        } catch (SQLException ex){
            ex.getMessage();
        } finally {
            DbUtils.closeQuietly(conn);
        }
        return category;
    }
}

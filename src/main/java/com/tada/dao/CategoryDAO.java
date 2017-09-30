
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

import com.tada.DAOInterface;
import com.tada.DBConnection;
import com.tada.PropertiesUtil;
import com.tada.beans.Category;


public class CategoryDAO implements DAOInterface<Category> {
    static Properties scripts = PropertiesUtil.getProperties("sql/category.properties");

    @Override
    public int insert(Category category){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_insert = scripts.getProperty("insert");

        System.out.println(sql_insert);
        System.out.println(category.toString());

        int result = 0;
        try {
            result = qr.update(conn,sql_insert, category.getName());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int update(Category category){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_update = scripts.getProperty("update");

        int result = 0;
        try {
            result = qr.update(
                conn,
                sql_update,
                category.getName(),
                category.getIdCategory()
            );
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public int delete(Category category){
        return delete(category.getIdCategory());
    }

    @Override
    public int delete(int id){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_delete = scripts.getProperty("delete");
        int result = 0;
        try {
            result = qr.update(conn, sql_delete, id);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public List<Category> findAll(){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = scripts.getProperty("select");

        ResultSetHandler<List<Category>> rlh = new BeanListHandler<>(Category.class);
        List<Category> list = new ArrayList<>();
        try {
            list = qr.query(conn, sql_select, rlh);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Category findById(int id){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = scripts.getProperty("select.by.id");
        ResultSetHandler<Category> rsh = new BeanHandler<>(Category.class);
        Category category = new Category();
        try {
            category = qr.query(conn, sql_select, rsh, id);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return category;
    }
}

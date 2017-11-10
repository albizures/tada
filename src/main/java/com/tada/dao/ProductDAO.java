package com.tada.dao;

import com.tada.DAOInterface;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.tada.DBConnection;
import com.tada.PropertiesUtil;

import com.tada.beans.Product;

import com.tada.handlers.ProductHandler;
import com.tada.handlers.ProductListHandler;

public class ProductDAO implements DAOInterface<Product> {
    static Properties scripts = PropertiesUtil.getProperties("sql/product.properties");

    @Override
    public Product insert(Product product){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_insert = scripts.getProperty("insert");
        
        ResultSetHandler <Product> handler = new ProductHandler();
        try {
            return qr.insert(
                conn,
                sql_insert,
                handler,
                product.getName(),
                product.getPrice(),
                product.getCategory().getIdCategory(),
                product.getDescription(),
                product.getStock(),
                product.getImage().getIdImage()
            );
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public int update(Product product){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_insert = scripts.getProperty("update");
        int result = 0;
        try {
            result = qr.update(
                conn,
                sql_insert,
                product.getName(),
                product.getPrice(),
                product.getCategory().getIdCategory(),
                product.getDescription(),
                product.getStock(),
                product.getImage().getIdImage(),
                product.getIdProduct()  
            );
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    @Override
    public int delete(int id){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_insert = scripts.getProperty("product");

        int result = 0;
        try {
            result = qr.update(conn,sql_insert,id);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return result;
    }

    @Override
    public Product findById(int id){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = scripts.getProperty("select.by.id");

        ResultSetHandler <Product> handler = new ProductHandler();

        Product product = new Product();
        try {
            product = qr.query(conn, sql_select, handler, id);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return product;
    }

    @Override
    public List<Product> findAll(){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = scripts.getProperty("select");
        ProductListHandler handler = new ProductListHandler();
        List<Product> list = new ArrayList<>();
        try {
            list = qr.query(conn, sql_select, handler);
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    public List<Product> findByCriteria(String name){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = scripts.getProperty("select.by.criteria");
        ProductListHandler handler = new ProductListHandler();
        List<Product> list = new ArrayList<>();
        try {
            list = qr.query(conn,sql_select, handler);
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
        }
        return list;
    }
}

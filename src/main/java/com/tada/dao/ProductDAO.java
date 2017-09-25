package com.tada.dao;

import com.tada.DBConnection;
import com.tada.beans.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class ProductDAO {
    public int insert(Product product){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_insert = "INSERT INTO product " +
                            "(name," +
                            "price," +
                            "id_category," +
                            "description," +
                            "stock)" +
                            "VALUES " +
                            "(?,?,?,?,?)";
        int result = 0;
        try {
            result = qr.update(conn,sql_insert,
                        product.getName(),
                        product.getPrice(),
                        product.getIdCategory(),
                        product.getDescription(),
                        product.getStock());

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
        }
        return result;
    }

    public int update(Product product){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_insert = "UPDATE product " +
                            "SET " +
                            "name = ?," +
                            "price = ?," +
                            "id_category = ?," +
                            "description = ?," +
                            "stock = ? " +
                            "WHERE id_product = ?";
        int result = 0;
        try {
            result = qr.update(conn,sql_insert,
                        product.getName(),
                        product.getPrice(),
                        product.getIdCategory(),
                        product.getDescription(),
                        product.getStock(),
                        product.getIdProduct());
        } catch (SQLException ex){
            ex.getMessage();
        } finally {
            //DbUtils.closeQuietly(conn);
        }
        return result;
    }
    
    public int delete(int id){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_insert = "DELETE FROM product " +
                            "WHERE id_product = ?";
        System.out.println(sql_insert);
        System.out.println(id);
        int result = 0;
        try {
            result = qr.update(conn,sql_insert,id);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        } finally {
            //DbUtils.closeQuietly(conn);
        }
        return result;
    }

    public Product get(int id){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = "SELECT product.id_product AS idProduct," +
                            "product.name," +
                            "product.price," +
                            "product.id_category AS idCategory," +
                            "product.description," +
                            "product.stock " +
                            "FROM product " +
                            "WHERE product.id_product = ?";
        ResultSetHandler<Product> rsh = new BeanHandler<>(Product.class);
        Product product = new Product();
        try {
            product = qr.query(conn,sql_select, rsh,id);
        } catch (SQLException ex){
            ex.getMessage();
        } finally {
            //DbUtils.closeQuietly(conn);
        }
        return product;
    }

    public List<Product> list(){
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = "SELECT id_product AS idProduct," +
                            "name," +
                            "price," +
                            "id_category AS idCategory," +
                            "description," +
                            "stock " +
                            "FROM product";
        
        ResultSetHandler<List<Product>> rlh = new BeanListHandler<>(Product.class);
        List<Product> list = new ArrayList<>();
        try {
            list = qr.query(conn,sql_select, rlh);
        } catch (SQLException ex) {
            System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            ex.getMessage();
        } finally {
            //DbUtils.closeQuietly(conn);
        }
        return list;
    }
}

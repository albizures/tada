package com.tada.dao;

import java.util.Properties;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.tada.DAOInterface;
import com.tada.DBConnection;
import com.tada.PropertiesUtil;
import com.tada.beans.Image;

public class ImageDAO implements DAOInterface<Image> {
    Properties scripts = PropertiesUtil.getProperties("sql/image.properties");
    
    @Override
    public Image insert(Image image){
        QueryRunner runner = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String query = scripts.getProperty("insert");
        ResultSetHandler<Long> handler = new ScalarHandler<>();
        try {
            image.setIdImage((int) (long) runner.insert(conn, query, handler, image.getUrl()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return image;
    }
    
    @Override
    public int update(Image image){
        QueryRunner runner = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String query = scripts.getProperty("update");

        int result = 0;
        try {
            result = runner.update(
                conn,
                query,
                image.getUrl(),
                image.getIdImage()
            );
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    public int delete(Image image){
        return delete(image.getIdImage());
    }

    @Override
    public int delete(int id){
        QueryRunner runner = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String query = scripts.getProperty("delete");
        int result = 0;
        try {
            result = runner.update(conn, query, id);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
    @Override
    public List<Image> findAll(){
        QueryRunner runner = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String query = scripts.getProperty("select");

        ResultSetHandler<List<Image>> handler = new BeanListHandler<>(Image.class);
        List<Image> list = new ArrayList<>();
        try {
            list = runner.query(conn, query, handler);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Image findById(int id){
        QueryRunner runner = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String query = scripts.getProperty("select.by.id");

        ResultSetHandler<Image> handler = new BeanHandler<>(Image.class);
        Image category = new Image();
        try {
            category = runner.query(conn, query, handler, id);
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return category;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tada.dao;

import com.tada.DAOInterface;
import com.tada.DBConnection;
import com.tada.PropertiesUtil;
import com.tada.beans.Card;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author erick
 */
public class CardDAO implements DAOInterface<Card>{
    Properties scripts = PropertiesUtil.getProperties("sql/card.properties");

    @Override
    public List<Card> findAll() {
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = scripts.getProperty("select");
        ResultSetHandler<List<Card>> rlh = new BeanListHandler<>(Card.class);
        List<Card> list = new  ArrayList<>();
        try {
            list = qr.query(conn,sql_select,rlh);
        } catch (SQLException ex ){
            System.out.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public Card findById(int id) {
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = scripts.getProperty("select.by.id");
        ResultSetHandler<Card> rsh = new BeanHandler<>(Card.class);
        Card card = new Card();
        try {
            card = qr.query(conn,sql_select, rsh,id);
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return card;
    }
    
    public List<Card> findByUser(int id) {
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_select = scripts.getProperty("select.by.user");
        ResultSetHandler<List<Card>> rlh = new BeanListHandler<>(Card.class);
        List<Card> list = new  ArrayList<>();
        try {
            list = qr.query(conn,sql_select,rlh,id);
        } catch (SQLException ex ){
            System.out.println(ex.getMessage());
        }
        return list;
    }
    
    @Override
    public Card insert(Card object) {
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_inser = scripts.getProperty("insert");
        ResultSetHandler<Card> h = new BeanHandler<>(Card.class);
        try {
            return qr.insert(conn, sql_inser,h,object.getName(),
                    object.getNumber(),object.getMonth(),object.getYear(),
                    object.getId_user());
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public int update(Card object) {
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_update = scripts.getProperty("update");
        ResultSetHandler<Card> h = new BeanHandler<>(Card.class);
        int result = 0;
        try {
            result = qr.update(conn,sql_update,h,object.getName(),
                    object.getName(),
                    object.getMonth(),
                    object.getYear(),
                    object.getId_user());
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int delete(int id) {
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String delete = scripts.getProperty("delete");
        int result = 0;
        try {
            result = qr.update(conn,delete,id);
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tada.dao;

import com.tada.DAOInterface;
import com.tada.DBConnection;
import com.tada.PropertiesUtil;
import com.tada.beans.Order;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 *
 * @author erick
 */
public class OrderDAO implements DAOInterface<Order>{
    static Properties scripts = PropertiesUtil.getProperties("sql/order.properties");
    @Override
    public List<Order> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order insert(Order object) {
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String sql_insert = scripts.getProperty("insert");
        ResultSetHandler<Order> handler = new BeanHandler<>(Order.class);
        try {
            return qr.insert(conn, sql_insert, handler,
                    object.getDate(),
                    object.getIdUser(),
                    object.getIdOrderStatus());
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public int update(Order object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

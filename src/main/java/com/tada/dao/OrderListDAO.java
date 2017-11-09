/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tada.dao;

import com.tada.DAOInterface;
import com.tada.DBConnection;
import com.tada.PropertiesUtil;
import com.tada.beans.OrderList;
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
public class OrderListDAO implements DAOInterface<OrderList>{
    static Properties scripts = PropertiesUtil.getProperties("sql/orderdetail.properties");
    @Override
    public List<OrderList> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderList findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderList insert(OrderList object) {
        QueryRunner qr = new QueryRunner();
        Connection conn = DBConnection.getConnection();
        String insert = scripts.getProperty("insert");
        ResultSetHandler<OrderList> handler = new BeanHandler<>(OrderList.class);
        try {
            return qr.insert(conn, insert, handler,
                    object.getIdOrder(),
                    object.getIdProduct(),
                    object.getQuantity());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public int update(OrderList object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

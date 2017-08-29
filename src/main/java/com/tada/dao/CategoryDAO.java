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
import org.apache.commons.dbutils.QueryRunner;
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
        int insert = 0;
        try {
            insert = qr.update(sql_insert, category.getName());
        } catch (SQLException ex) {
            ex.getMessage();
        } finally {
            //DBConnection.closeConnection();
        }
        return insert;
    }
}

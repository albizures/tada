package com.tada.umgproject;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    
    private static Connection conn;
    
    public static Connection getConnection(){
        if (conn != null) {
            return conn;
        }
        final Properties dbConfig = PropertiesUtil.getProperties("db.properties");
        final String dbName = dbConfig.getProperty("db.name");
        final String dbUser = dbConfig.getProperty("db.user");
        final String dbPassword = dbConfig.getProperty("db.password");
        
        try{     
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, dbUser, dbPassword);
            return conn;
        } catch(SQLException e){
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static ResultSet exec (String query) {
        try {
            Statement stmt = getConnection().createStatement();
            return stmt.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}

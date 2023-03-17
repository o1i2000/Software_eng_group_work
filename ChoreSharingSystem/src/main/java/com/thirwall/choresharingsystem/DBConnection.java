/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thirwall.choresharingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author thura
 */
public class DBConnection {
    private Connection conn;
    
    public DBConnection() {
        conn = null;
    }
    
    public boolean Connect(String filename) {
        try {
            String url = "jdbc:sqlite:" + filename;
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to " + filename + " has been established!");
        }
        catch (SQLException e) {
            System.out.println("Failed to connect to " + filename);
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean RunSQL(String sql) {
        if (conn == null) {
            System.out.println("There is no database loaded. Cannot run SQL.");
            return false;
        }
        try {
            Statement sqlStatement = conn.createStatement();
            sqlStatement.execute(sql);
        }
        catch(SQLException e) {
            System.out.println("Failed to execute " + sql);
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public ResultSet RunSQLQuery(String sql) {
        ResultSet result;
        if (conn == null) {
            System.out.println("There is no database loaded. Cannot run SQL.");
            return null;
        }
        try {
            Statement sqlStatement = conn.createStatement();
            result = sqlStatement.executeQuery(sql);
        }
        catch(SQLException e) {
            System.out.println("Failed to execute " + sql);
            System.out.println(e.getMessage());
            return null;
        }
        return result;
    }
}

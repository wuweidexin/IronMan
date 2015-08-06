/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chen.hibernateconvert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;


/**
 *
 * @author pippo
 */
public class OracleDBUtil {
    static Connection conn = null;
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public static Connection getConnection() {
//        DbConfig dbConfig = DbConfig.getDbConfig();
//        String url = "jdbc:oracle:thin:@"+dbConfig.getServerIP()+":"+dbConfig.getServerPort()+":"+dbConfig.getSid();
//        
//        try {
//            if(conn==null){
//                conn = DriverManager.getConnection(url, dbConfig.getUserName(), dbConfig.getPassWord());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }

    public static void close() {
        if (null != conn) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        
    public static void close(PreparedStatement ps, ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (null != ps) {
            try {
                ps.close();
                ps = null;
            } catch (SQLException e) {
                e.printStackTrace();
            } 
        }
        if (null != conn) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

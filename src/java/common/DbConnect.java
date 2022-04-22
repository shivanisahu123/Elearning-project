/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author dell
 */
public class DbConnect {

    public static Connection con;

    public static Connection connectMySql() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logintab", "root", "root");
            System.out.println("Connection successfully");
            return con;
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static void main(String[] args) {
        connectMySql();
    }

}

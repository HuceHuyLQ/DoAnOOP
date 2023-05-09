/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;


/**
 *
 * @author huylequang
 */
public class DatabaseConnect {
    public Connection conn;
    String url = "jdbc:mysql://localhost:3306/QuanLyPhong";
    String user;
    String password;

    public DatabaseConnect(){
        
    };
    
    public void Init(Connection conn, String user, String password) {
        this.conn = conn;
        this.user = user;
        this.password = password;
    }
    
    public void Connect(String user, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(this.url,user,password);
            System.out.println("CONNECTED TO DATABASE");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

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
    private Connection conn;
    String url = "jdbc:mysql://localhost:3306/NguoiDung";
    String user;
    String password;

    public DatabaseConnect(){
        
    };
    
    public void Init(Connection conn, String user, String password) {
        this.conn = conn;
        this.user = user;
        this.password = password;
    }
    
    public boolean Connect(String user, String password) {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("CONNECTED");
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

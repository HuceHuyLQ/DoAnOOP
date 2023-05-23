/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;
import model.DatabaseConnect;
import model.Phong;
/**
 *
 * @author 03qua
 */
public class PhongDao {
    private static DatabaseConnect db = new DatabaseConnect();
    private static Connection conn = db.Connect();
    
    public List<Phong> layDanhSachPhong() throws SQLException{
        List<Phong> danhSachPhong = new ArrayList<Phong>();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Phong");
        while(resultSet.next()){
            String maPhong = resultSet.getString("MaPhong");
            String loaiPhong = resultSet.getString("LoaiPhong");
            float giaTien = Float.parseFloat(resultSet.getString("GiaThue"));
            Phong phong = new Phong(maPhong,loaiPhong,giaTien);
            danhSachPhong.add(phong);
        }
        return danhSachPhong;
    }
}

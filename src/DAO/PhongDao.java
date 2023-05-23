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
    
    public void themPhong(String MaPhong, String LoaiPhong, float GiaThue) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO Phong(MaPhong, LoaiPhong, GiaThue) VALUES(?,?,?)");
        preparedStatement.setString(1,MaPhong);
        preparedStatement.setString(2,LoaiPhong);
        preparedStatement.setFloat(3, GiaThue);
        preparedStatement.executeUpdate();
    }
    
    public Phong timPhongTheoMa(String MaPhong) throws SQLException{
        String loaiPhong;
        Float giaThue;
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Phong WHERE MaPhong=?");
        preparedStatement.setString(1,MaPhong);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            loaiPhong = resultSet.getString("LoaiPhong");
            giaThue = Float.valueOf(resultSet.getString("GiaThue"));
            Phong phong = new Phong(MaPhong,loaiPhong,giaThue);
            return phong;
        }else{
            return null;
        }
    }
    
    public List<Phong> timPhongTheoLoaiPhong(String LoaiPhong) throws SQLException{
        List<Phong> dsp = new ArrayList<Phong>();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Phong WHERE LoaiPhong=?");
        preparedStatement.setString(1,LoaiPhong);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            String maPhong = resultSet.getString("MaPhong");
            float giaThue = Float.parseFloat(resultSet.getString("GiaThue"));
            Phong phong = new Phong(maPhong,LoaiPhong,giaThue);
            dsp.add(phong);
        }
        return dsp;
    }
    
    public List<Phong> timPhongTheoGiaTien(Float GiaTien) throws SQLException{
        List<Phong> dsp = new ArrayList<Phong>();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM Phong WHERE GiaThue = ?");
        preparedStatement.setFloat(1, GiaTien);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            String maPhong = resultSet.getString("MaPhong");
            String loaiPhong = resultSet.getString("LoaiPhong");
            Phong phong = new Phong(maPhong, loaiPhong, GiaTien);
            dsp.add(phong);
        }
        return dsp;
    }
    
    public void xoaPhong(String maphong) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM Phong WHERE MaPhong=?");
        preparedStatement.setString(1, maphong);
        preparedStatement.executeUpdate();
    }
}

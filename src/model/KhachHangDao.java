/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.*;
import java.sql.*;

/**
 *
 * @author huylequang
 */
public class KhachHangDao {
    private static DatabaseConnect dbconnect = new DatabaseConnect();
    private static Connection conn = dbconnect.Connect();
    
    public List<KhachHang> layDanhSachKhachHang() throws SQLException{
        List<KhachHang> danhSachKH = new ArrayList<KhachHang>();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM KhachHang");
        while(resultSet.next()){
            String maKH = resultSet.getString("MaKhachHang");
            String hoTenKH = resultSet.getString("HoTenKhachHang");
            String SDTKH = resultSet.getString("SdtKhachHang");
            KhachHang khachhang = new KhachHang(maKH,hoTenKH,SDTKH);
            danhSachKH.add(khachhang);
        }
        return danhSachKH;
    }
    
    public void themKhachHang(String makh, String hoten, String sdt) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO KhachHang(MaKhachHang, HoTenKhachHang, SdtKhachHang) VALUES(?,?,?)");
        preparedStatement.setString(1,makh);
        preparedStatement.setString(2,hoten);
        preparedStatement.setString(3,sdt);
        preparedStatement.executeUpdate();
    }
    
    public KhachHang timKhachHangBangMaKH(String MaKH) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM KhachHang WHERE MaKhachHang=?");
        preparedStatement.setString(1,MaKH);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            String hoTenKH = resultSet.getString("HoTenKhachHang");
            String SDTKH = resultSet.getString("SdtKhachHang");
            KhachHang khachhang = new KhachHang(MaKH,hoTenKH,SDTKH);
            return khachhang;
        }else{
            return null;
        }
    }
    
    public void xoaKhachHang(KhachHang khachhang) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM KhachHang WHERE MaKhachHang=?");
        preparedStatement.setString(1, khachhang.getMaKH());
        preparedStatement.executeUpdate();
    }
}

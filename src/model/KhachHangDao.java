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
    private static String user = "root";
    private static String password = "@Quanghuydeple03";
    private static Connection conn = dbconnect.Connect(user, password);
    
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
    
    public KhachHang timKhachHangBangMaKH(String MaKH) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM KhachHang WHERE MaKH=?");
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
}

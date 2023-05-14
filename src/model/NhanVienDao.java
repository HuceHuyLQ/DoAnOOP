/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author huylequang
 */
public class NhanVienDao {
    private static DatabaseConnect dbconnect = new DatabaseConnect();
    private static Connection conn = dbconnect.Connect();
    public static NhanVien layThongTinNhanVienTheoMaNV(int maNV) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        NhanVien nhanVien = null;

        try{
            String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, maNV);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int maNVResult = resultSet.getInt("MaNV");
                String hoTenNV = resultSet.getString("HoTenNV");
                String sdtNV = resultSet.getString("SDTNV");
                String taiKhoanNV = resultSet.getString("TaiKhoanNV");
                String matKhauNV = resultSet.getString("MatKhauNV");
                nhanVien = new NhanVien(maNVResult, hoTenNV, sdtNV, taiKhoanNV, matKhauNV);
            }
        } catch(SQLException ex){
            ex.getStackTrace();
        }
        return nhanVien;
    }
    
    public static NhanVien layThongTinNhanVienTheoUsername(String username) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        NhanVien nhanVien = null;

        try{
            String sql = "SELECT * FROM NhanVien WHERE TaiKhoanNV = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int maNVResult = resultSet.getInt("MaNV");
                String hoTenNV = resultSet.getString("HoTenNV");
                String sdtNV = resultSet.getString("SDTNV");
                String taiKhoanNV = resultSet.getString("TaiKhoanNV");
                String matKhauNV = resultSet.getString("MatKhauNV");
                nhanVien = new NhanVien(maNVResult, hoTenNV, sdtNV, taiKhoanNV, matKhauNV);
            }
        } catch(SQLException ex){
            ex.getStackTrace();
        }
        return nhanVien;
    }

    // Kiểm tra thông tin đăng nhập của nhân viên
    public static boolean kiemTraDangNhap(String taiKhoan, String matKhau) throws SQLException {
       
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean ketQua = false;

        try {
            String sql = "SELECT * FROM NhanVien WHERE TaiKhoanNV = ? AND MatKhauNV = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, taiKhoan);
            statement.setString(2, matKhau);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ketQua = true;
            }
        } catch(SQLException ex){
            ex.getStackTrace();
        }

        return ketQua;
    }
}

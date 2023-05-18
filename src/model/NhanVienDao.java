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
    private static NhanVien nhanVien = new NhanVien();
    public static NhanVien layThongTinNhanVienTheoMaNV(int maNV) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String sql = "SELECT * FROM NhanVien WHERE MaNhanVien = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, maNV);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String maNVResult = resultSet.getString("MaNV");
                String hoTenNV = resultSet.getString("HoTenNV");
                String sdtNV = resultSet.getString("SDTNV");
                String email = resultSet.getString("Email");
                String taiKhoanNV = resultSet.getString("TaiKhoanNV");
                String matKhauNV = resultSet.getString("MatKhauNV");
                nhanVien = new NhanVien(maNVResult, hoTenNV, sdtNV, email, taiKhoanNV, matKhauNV);
            }
        } catch(SQLException ex){
            ex.getStackTrace();
        }
        return nhanVien;
    }
    
    public static NhanVien layThongTinNhanVienTheoUsername(String username) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String sql = "SELECT * FROM NhanVien WHERE TenTK = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String maNVResult = resultSet.getString("MaNhanVien");
                String hoTenNV = resultSet.getString("TenNhanVien");
                String sdtNV = resultSet.getString("SdtNV");
                String email = resultSet.getString("Email");
                String taiKhoanNV = resultSet.getString("TenTK");
                String matKhauNV = resultSet.getString("MatKhau"); 
                nhanVien = new NhanVien(maNVResult, hoTenNV, sdtNV, email, taiKhoanNV, matKhauNV);
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
            String sql = "SELECT * FROM NhanVien WHERE TenTK = ? AND MatKhau = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, taiKhoan);
            statement.setString(2, matKhau);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nhanVien = layThongTinNhanVienTheoUsername(taiKhoan);
                ketQua = true;
            }
        } catch(SQLException ex){
            ex.getStackTrace();
        }

        return ketQua;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }
    
}

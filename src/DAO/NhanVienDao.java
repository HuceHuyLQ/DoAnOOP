/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import model.DatabaseConnect;
import model.NhanVien;

/**
 *
 * @author huylequang
 */
public class NhanVienDao {
    private static DatabaseConnect dbconnect = new DatabaseConnect();
    private static Connection conn = dbconnect.Connect();
    private static NhanVien nhanVien = new NhanVien();
    
    public List<NhanVien> layDanhSachNhanVien() throws SQLException{
        List<NhanVien> dsnv = new ArrayList<NhanVien>();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM NhanVien");
        while(resultSet.next()){
            String maNhanVien = resultSet.getString("MaNhanVien");
            String tenNhanVien = resultSet.getString("TenNhanVien");
            String sdtNhanVien = resultSet.getString("SdtNV");
            String emailNhanVien = resultSet.getString("Email");
            String tenTK = resultSet.getString("TenTK");
            String matKhau = resultSet.getString("MatKhau");
            String vaiTro = resultSet.getString("VaiTro");
            NhanVien nv = new NhanVien(maNhanVien,tenNhanVien,sdtNhanVien,emailNhanVien,tenTK,matKhau,vaiTro);
            dsnv.add(nv);
        }
        return dsnv;
    }
    
    public void themNhanVien(String maNhanVien, String tenNhanVien, String sdtNhanVien, String emailNhanVien, String tenTK, String matKhau, String vaiTro) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO NhanVien(MaNhanVien, TenNhanVien, SdtNV, Email, TenTk, MatKhau, VaiTro) VALUES(?,?,?,?,?,?,?)");
        preparedStatement.setString(1,maNhanVien);
        preparedStatement.setString(2,tenNhanVien);
        preparedStatement.setString(3,sdtNhanVien);
        preparedStatement.setString(4,emailNhanVien);
        preparedStatement.setString(5,tenTK);
        preparedStatement.setString(6,matKhau);
        preparedStatement.setString(7,vaiTro);
        preparedStatement.executeUpdate();
    }
    
    public static List<NhanVien> timNVTheoTen(String HoTen) throws SQLException{
        List<NhanVien> dsnv = new ArrayList<NhanVien>();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM NhanVien WHERE TenNV = ?");
        ps.setString(1,HoTen);
        ResultSet resultSet = ps.executeQuery();
        while(resultSet.next()){
            String maNhanVien = resultSet.getString("MaNhanVien");
            String tenNhanVien = resultSet.getString("TenNhanVien");
            String sdtNhanVien = resultSet.getString("SdtNV");
            String emailNhanVien = resultSet.getString("Email");
            String tenTK = resultSet.getString("TenTK");
            String matKhau = resultSet.getString("MatKhau");
            String vaiTro = resultSet.getString("VaiTro");
            NhanVien nv = new NhanVien(maNhanVien,tenNhanVien,sdtNhanVien,emailNhanVien,tenTK,matKhau,vaiTro);
            dsnv.add(nv);
        }
        return dsnv;
    }
    
    public static NhanVien layThongTinNhanVienTheoMaNV(int maNV) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            String sql = "SELECT * FROM NhanVien WHERE MaNhanVien = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, maNV);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String maNVResult = resultSet.getString("MaNhanVien");
                String hoTenNV = resultSet.getString("TenNhanVien");
                String sdtNV = resultSet.getString("SdtNV");
                String email = resultSet.getString("Email");
                String taiKhoanNV = resultSet.getString("TenTK");
                String matKhauNV = resultSet.getString("MatKhau");
                String vaiTroNV = resultSet.getString("VaiTro");
                nhanVien = new NhanVien(maNVResult, hoTenNV, sdtNV, email, taiKhoanNV, matKhauNV,vaiTroNV);
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
                String vaiTroNV = resultSet.getString("VaiTro");
                nhanVien = new NhanVien(maNVResult, hoTenNV, sdtNV, email, taiKhoanNV, matKhauNV,vaiTroNV);
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

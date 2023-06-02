/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.LuotThue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;

/**
 *
 * @author nguyenhuuhieu
 */
public class LuotThueDao {
    private static DatabaseConnect db = new DatabaseConnect();
    private static Connection conn = db.Connect();
    String MaLuotThue;
    String MaKhachHang;
    String MaPhong;
    String MaNhanVien;
    String NgayGioThue;
    double Coc ;
    double TongTien;
    String GhiChu;
    
    public boolean kiemTraTonTai(String MaLuotThue) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM LuotThue WHERE MaLuotThue=?");
        ps.setString(1, MaLuotThue);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int rowCount = rs.getInt(1);
        return rowCount>0;
    }
    
    public List<LuotThue> layDanhSachLuotThue() throws SQLException{
        List<LuotThue> danhSachLuotThue = new ArrayList<LuotThue>();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM LuotThue");
        while(resultSet.next()){
            String MaLuotThue = resultSet.getString("MaLuotThue");
            String MaKhachHang = resultSet.getString("MaKhachHang");
            String MaPhong = resultSet.getString("MaPhong");
            String MaNhanVien = resultSet.getString("MaNhanVien");
            String NgayGioThue = resultSet.getString("NgayGioThue");
            double Coc = resultSet.getDouble("Coc");
            double TongTien = resultSet.getDouble("TongTien");
            String GhiChu = resultSet.getString("GhiChu");
            LuotThue lt = new LuotThue(MaLuotThue, MaKhachHang, MaPhong, MaNhanVien, NgayGioThue, Coc, TongTien, GhiChu);
            danhSachLuotThue.add(lt);
        }
        return danhSachLuotThue;
    }
    
    public void themLuotThue(String MaLuotThue, String MaKhachHang, String MaPhongLT, String MaNhanVien, String NgayGioThue, double Coc, double TongTien, String GhiChu) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO LuotThue(MaLuotThue, MaKhachHang, MaPhong, MaNhanVien, NgayGioThue, Coc, TongTien, GhiChu) VALUES(?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,MaLuotThue);
        preparedStatement.setString(2,MaKhachHang);
        preparedStatement.setString(3, MaPhongLT);
        preparedStatement.setString(4, MaNhanVien);
        preparedStatement.setString(5, NgayGioThue);
        preparedStatement.setDouble(6, Coc);
        preparedStatement.setDouble(7, TongTien);
        preparedStatement.setString(8, GhiChu);
        preparedStatement.executeUpdate();
    }
    
    public LuotThue timLuotThueTheoMa(String MaLuotThue) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM LuotThue WHERE MaLuotThue =?");
        preparedStatement.setString(1,MaLuotThue);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            MaKhachHang = resultSet.getString("MaKhachHang");
            MaPhong = resultSet.getString("MaPhong");
            MaNhanVien = resultSet.getString("MaNhanVien");
            NgayGioThue = resultSet.getString("NgayGioThue");
            Coc = resultSet.getDouble("Coc");
            TongTien = resultSet.getDouble("TongTien");
            GhiChu = resultSet.getString("GhiChu");
            LuotThue lt = new LuotThue(MaLuotThue, MaKhachHang, MaPhong, MaNhanVien, NgayGioThue, Coc, TongTien, GhiChu);
            return lt;
        }else{
            return null;
        }
    }
    
    public void xoaLuotThue(String MaLuotThue) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM LuotThue WHERE MaLuotThue=?");
        preparedStatement.setString(1, MaLuotThue);
        preparedStatement.executeUpdate();
    }
    
    public void suaLuotThue(String MaLuotThue, String MaKhachHang, String MaPhongLT, String MaNhanVien, String NgayGioThue, double Coc, double TongTien, String GhiChu) throws SQLException{
        //Hàm sửa Luot thue
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE LuotThue SET MaKhachHang=?,MaPhong=?,MaNhanVien=?,NgayGioThue=?,Coc=?,TongTien=?,GhiChu=? WHERE MaLuotThue=?");
        preparedStatement.setString(1, MaKhachHang);
        preparedStatement.setString(2, MaPhongLT);
        preparedStatement.setString(3, MaNhanVien);
        preparedStatement.setString(4, NgayGioThue);
        preparedStatement.setDouble(5, Coc);
        preparedStatement.setDouble(6, TongTien);
        preparedStatement.setString(7, GhiChu);
        preparedStatement.setString(8, MaLuotThue);
        int rs = preparedStatement.executeUpdate();
        if(rs>0){
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
        }        
    }
    
    
}

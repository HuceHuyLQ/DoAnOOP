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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.*;
import view.MainForm;

/**
 *
 * @author nguyenhuuhieu
 */
public class LuotThueDao {
    private static DatabaseConnect db = new DatabaseConnect();
    private static Connection conn = db.Connect();
    LuotThue luotthue = new LuotThue();
    MainForm main = new MainForm();
    String MaLuotThue;
    String MaKhachHang;
    String MaPhong;
    String MaNhanVien;
    String NgayThue;
    String GioBatDau;
    String GioKetThuc;
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
    
    
    public boolean kiemTraPhongTonTaiTrongKhoangTG(String MaPhong, String NgayThue, String GioBatDau, String GioKetThuc) throws SQLException{
        String query = "SELECT COUNT(*) FROM LuotThue WHERE MaPhong = ? AND NgayThue = ? AND GioBatDau <= ? AND GioKetThuc >= ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, MaPhong);
            statement.setString(2, NgayThue);
            statement.setString(3, GioKetThuc);
            statement.setString(4, GioBatDau);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }    
        return false;
    }
    
    public boolean kiemTraPhongTonTaiTrongKhoangTG1(String MaPhong, String NgayThue, String GioBatDau, String GioKetThuc, String MaLuotThue) throws SQLException{
        String query = "SELECT COUNT(*) FROM LuotThue WHERE MaPhong = ? AND NgayThue = ? AND GioBatDau <= ? AND GioKetThuc >= ? AND MaLuotThue <>?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, MaPhong);
            statement.setString(2, NgayThue);
            statement.setString(3, GioBatDau);
            statement.setString(4, GioKetThuc);
            statement.setString(5, MaLuotThue);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }    
        return false;
    }
    
    public boolean kiemTraGioTonTai(String GioBatDau, String GioKetThuc) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT COUNT(*) FROM luotthue WHERE GioBatDau = ? AND GioKetThuc = ?");
        preparedStatement.setString(1, GioBatDau);
        preparedStatement.setString(2, GioKetThuc);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0; // Trả về true nếu có bản ghi tồn tại, ngược lại trả về false
        }
    return false;
}
    
    
    public List<LuotThue> layDanhSachLuotThue() throws SQLException{
        List<LuotThue> danhSachLuotThue = new ArrayList<LuotThue>();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM luotthue");
        while(resultSet.next()){
            String MaLuotThue = resultSet.getString("MaLuotThue");
            String MaKhachHang = resultSet.getString("MaKhachHang");
            String MaPhong = resultSet.getString("MaPhong");
            String MaNhanVien = resultSet.getString("MaNhanVien");
            String NgayThue = resultSet.getString("NgayThue");
            String GioBatDau = resultSet.getString("GioBatDau");
            String GioKetThuc = resultSet.getString("GioKetThuc");
            double Coc = resultSet.getDouble("Coc");
            double TongTien = resultSet.getDouble("TongTien");
            String GhiChu = resultSet.getString("GhiChu");
            LuotThue lt = new LuotThue(MaLuotThue, MaKhachHang, MaPhong, MaNhanVien, NgayThue, GioBatDau, GioKetThuc, Coc, TongTien, GhiChu);
            danhSachLuotThue.add(lt);
        }
        return danhSachLuotThue;
    }
    
    public void TinhTongTien(){
        Statement statement;
        try {     
            statement = conn.createStatement();
            int resultSet = statement.executeUpdate("UPDATE luotthue INNER JOIN phong ON luotthue.MaPhong = phong.MaPhong SET luotthue.TongTien = phong.GiaThue - luotthue.Coc");  
        } catch (SQLException ex) {
            Logger.getLogger(LuotThueDao.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void themLuotThue(String MaLuotThue, String MaKhachHang, String MaPhongLT, String MaNhanVien, String NgayThue, String GioBatDau, String GioKetThuc, double Coc, double TongTien, String GhiChu) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO luotthue(MaLuotThue, MaKhachHang, MaPhong, MaNhanVien, NgayThue, GioBatDau, GioKetThuc, Coc, TongTien, GhiChu) VALUES(?,?,?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1,MaLuotThue);
        preparedStatement.setString(2,MaKhachHang);
        preparedStatement.setString(3, MaPhongLT);
        preparedStatement.setString(4, MaNhanVien);
        preparedStatement.setString(5, NgayThue);
        preparedStatement.setString(6, GioBatDau);
        preparedStatement.setString(7, GioKetThuc);
        preparedStatement.setDouble(8, Coc);
        preparedStatement.setDouble(9, TongTien);
        preparedStatement.setString(10, GhiChu);
        preparedStatement.executeUpdate();
        TinhTongTien();
    }
    
    public LuotThue timLuotThueTheoMa(String MaLuotThue) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM luotthue WHERE MaLuotThue =?");
        preparedStatement.setString(1,MaLuotThue);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            MaKhachHang = resultSet.getString("MaKhachHang");
            MaPhong = resultSet.getString("MaPhong");
            MaNhanVien = resultSet.getString("MaNhanVien");
            NgayThue = resultSet.getString("NgayThue");
            GioBatDau = resultSet.getString("GioBatDau");
            GioKetThuc = resultSet.getString("GioKetThuc");
            Coc = resultSet.getDouble("Coc");
            TongTien = resultSet.getDouble("TongTien");
            GhiChu = resultSet.getString("GhiChu");
            LuotThue lt = new LuotThue(MaLuotThue, MaKhachHang, MaPhong, MaNhanVien, NgayThue,GioBatDau,GioKetThuc, Coc, TongTien, GhiChu);
            return lt;
        }else{
            return null;
        }
    }
    
    
    public List<LuotThue> timLuotThueTheoMaKH(String MaKH) throws SQLException {
        List<LuotThue> luotThueList = new ArrayList<>();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM luotthue WHERE MaKhachHang =?");
        preparedStatement.setString(1, MaKH);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            MaLuotThue = resultSet.getString("MaLuotThue");
            MaPhong = resultSet.getString("MaPhong");
            MaNhanVien = resultSet.getString("MaNhanVien");
            NgayThue = resultSet.getString("NgayThue");
            GioBatDau = resultSet.getString("GioBatDau");
            GioKetThuc = resultSet.getString("GioKetThuc");
            Coc = resultSet.getDouble("Coc");
            TongTien = resultSet.getDouble("TongTien");
            GhiChu = resultSet.getString("GhiChu");

            LuotThue lt = new LuotThue(MaLuotThue, MaKH, MaPhong, MaNhanVien, NgayThue, GioBatDau, GioKetThuc, Coc, TongTien, GhiChu);
            luotThueList.add(lt);
        }
    return luotThueList;
    }
    
    public List<LuotThue> timLuotThueTheoMaP(String MaPhong) throws SQLException {
        List<LuotThue> luotThueList = new ArrayList<>();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM luotthue WHERE MaPhong =?");
        preparedStatement.setString(1, MaPhong);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            MaLuotThue = resultSet.getString("MaLuotThue");
            MaKhachHang = resultSet.getString("MaKhachHang");
            MaNhanVien = resultSet.getString("MaNhanVien");
            NgayThue = resultSet.getString("NgayThue");
            GioBatDau = resultSet.getString("GioBatDau");
            GioKetThuc = resultSet.getString("GioKetThuc");
            Coc = resultSet.getDouble("Coc");
            TongTien = resultSet.getDouble("TongTien");
            GhiChu = resultSet.getString("GhiChu");

            LuotThue lt = new LuotThue(MaLuotThue, MaKhachHang, MaPhong, MaNhanVien, NgayThue, GioBatDau, GioKetThuc, Coc, TongTien, GhiChu);
            luotThueList.add(lt);
        }
    return luotThueList;
    }

    public List<LuotThue> timLuotThueTheoMaNV(String MaNV) throws SQLException {
        List<LuotThue> luotThueList = new ArrayList<>();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM luotthue WHERE MaNhanVien =?");
        preparedStatement.setString(1, MaNV);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            MaLuotThue = resultSet.getString("MaLuotThue");
            MaKhachHang = resultSet.getString("MaKhachHang");
            MaPhong = resultSet.getString("MaPhong");
            NgayThue = resultSet.getString("NgayThue");
            GioBatDau = resultSet.getString("GioBatDau");
            GioKetThuc = resultSet.getString("GioKetThuc");
            Coc = resultSet.getDouble("Coc");
            TongTien = resultSet.getDouble("TongTien");
            GhiChu = resultSet.getString("GhiChu");

            LuotThue lt = new LuotThue(MaLuotThue, MaKhachHang, MaPhong, MaNV, NgayThue, GioBatDau, GioKetThuc, Coc, TongTien, GhiChu);
            luotThueList.add(lt);
        }
    return luotThueList;
    }
    
    public List<LuotThue> timLuotThueTheoNgayThue(String NgayThue) throws SQLException {
        List<LuotThue> luotThueList = new ArrayList<>();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM luotthue WHERE NgayThue =?");
        preparedStatement.setString(1, NgayThue);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            MaLuotThue = resultSet.getString("MaLuotThue");
            MaKhachHang = resultSet.getString("MaKhachHang");
            MaPhong = resultSet.getString("MaPhong");
            MaNhanVien = resultSet.getString("MaNhanVien");
            GioBatDau = resultSet.getString("GioBatDau");
            GioKetThuc = resultSet.getString("GioKetThuc");
            Coc = resultSet.getDouble("Coc");
            TongTien = resultSet.getDouble("TongTien");
            GhiChu = resultSet.getString("GhiChu");

            LuotThue lt = new LuotThue(MaLuotThue, MaKhachHang, MaPhong, MaNhanVien, NgayThue, GioBatDau, GioKetThuc, Coc, TongTien, GhiChu);
            luotThueList.add(lt);
        }
    return luotThueList;
    }
    
    public void xoaLuotThue(String MaLuotThue) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM luotthue WHERE MaLuotThue=?");
        preparedStatement.setString(1, MaLuotThue);
        preparedStatement.executeUpdate();
    }
    
    public void suaLuotThue(String MaLuotThue, String MaKhachHang, String MaPhongLT, String MaNhanVien, String NgayThue, String GioBatDau, String GioKetThuc, double Coc, double TongTien, String GhiChu) throws SQLException{
        //Hàm sửa Luot thue
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE luotthue SET MaKhachHang=?,MaPhong=?,MaNhanVien=?,NgayThue=?,GioBatDau=?,GioKetThuc=?,Coc=?,TongTien=?,GhiChu=? WHERE MaLuotThue=?");
        preparedStatement.setString(1, MaKhachHang);
        preparedStatement.setString(2, MaPhongLT);
        preparedStatement.setString(3, MaNhanVien);
        preparedStatement.setString(4, NgayThue);
        preparedStatement.setString(5, GioBatDau);
        preparedStatement.setString(6, GioKetThuc);
        preparedStatement.setDouble(7, Coc);
        preparedStatement.setDouble(8, TongTien);
        preparedStatement.setString(9, GhiChu);
        preparedStatement.setString(10, MaLuotThue);
        int rs = preparedStatement.executeUpdate();
        if(rs>0){
            TinhTongTien();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
        }        
    }
    
    public void suaLuotThuePro(String MaLuotThue, String MaKhachHang, String MaPhongLT, String MaNhanVien, String NgayThue, String GioBatDau, String GioKetThuc, double Coc, double TongTien, String GhiChu) throws SQLException{
        //Hàm sửa Luot thue
        PreparedStatement preparedStatement = conn.prepareStatement("UPDATE luotthue AS lt\n" +
                    "SET MaKhachHang = ?, MaPhong = ?, MaNhanVien = ?, NgayThue = ?, GioBatDau = ?, GioKetThuc = ?, Coc = ?, TongTien = ?, GhiChu = ?\n" +
                    "WHERE MaLuotThue = ?\n" +
                    "AND NOT EXISTS (\n" +
                    "    SELECT * FROM (\n" +
                    "        SELECT * FROM LuotThue AS tmp\n" +
                    "        WHERE tmp.MaPhong = ?\n" +
                    "        AND tmp.NgayThue = ?\n" +
                    "        AND (tmp.GioBatDau <= ? AND tmp.GioKetThuc >= ?) \n" +
                    "        AND tmp.MaLuotThue <>?\n" +
                    "    ) AS subquery\n" +
                    ");");
        preparedStatement.setString(1, MaKhachHang);
        preparedStatement.setString(2, MaPhongLT);
        preparedStatement.setString(3, MaNhanVien);
        preparedStatement.setString(4, NgayThue);
        preparedStatement.setString(5, GioBatDau);
        preparedStatement.setString(6, GioKetThuc);
        preparedStatement.setDouble(7, Coc);
        preparedStatement.setDouble(8, TongTien);
        preparedStatement.setString(9, GhiChu);
        preparedStatement.setString(10, MaLuotThue);
        preparedStatement.setString(11, MaPhongLT);
        preparedStatement.setString(12, NgayThue);
        preparedStatement.setString(13, GioBatDau);
        preparedStatement.setString(14, GioKetThuc);
        preparedStatement.setString(15, MaLuotThue);
        int rs = preparedStatement.executeUpdate();
        if(rs>0){
            TinhTongTien();
            JOptionPane.showMessageDialog(null, "Cập nhật thành công");
        } else{
            JOptionPane.showMessageDialog(null, "Phòng đã tồn tại!");
        }      
    }
}


//("UPDATE luotthue AS lt\n" +
//                    "SET MaKhachHang=?, MaPhong=?, MaNhanVien=?, NgayThue=?, GioBatDau=?, GioKetThuc=?, Coc=?, TongTien=?, GhiChu=?\n" +
//                    "WHERE MaLuotThue=? AND NOT EXISTS (\n" +
//                    "    SELECT * FROM (\n" +
//                    "        SELECT * FROM LuotThue\n" +
//                    "        WHERE (GioBatDau <= ? AND GioKetThuc >= ?) \n" +
//                    "    ) AS tmp\n" +
//                    "    WHERE tmp.MaPhong = ? AND tmp.NgayThue = ? AND tmp.MaLuotThue <> ?\n" +
//                    ")");

//AND MaLuotThue <> ?
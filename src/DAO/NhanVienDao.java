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
    
    public boolean kiemTraTonTai(String MaNV) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM NhanVien WHERE MaNhanVien=?");
        ps.setString(1, MaNV);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int rowCount = rs.getInt(1);
        return rowCount>0;
    }
    public boolean kiemTraTonTaiTK(String TaiKhoanNV) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM NhanVien WHERE TenTK=?");
        ps.setString(1, TaiKhoanNV);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int rowCount = rs.getInt(1);
        return rowCount>0;
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
    public static List<NhanVien> timNVTheoTen(String HoTen) throws SQLException {
        return executeQuery("SELECT * FROM NhanVien WHERE TenNhanVien LIKE CONCAT('%', ?, '%')", HoTen);
    }

    public static List<NhanVien> timNVVaiTro(String VaiTro) throws SQLException {
        return executeQuery("SELECT * FROM NhanVien WHERE VaiTro LIKE CONCAT('%', ?, '%')", VaiTro);
    }

    public static NhanVien layThongTinNhanVienTheoMaNV(String maNV) throws SQLException {
        List<NhanVien> results = executeQuery("SELECT * FROM NhanVien WHERE MaNhanVien =?", maNV);
        return results.isEmpty() ? null : results.get(0);
    }

    public static NhanVien layThongTinNhanVienTheoUsername(String username) throws SQLException {
        List<NhanVien> results = executeQuery("SELECT * FROM NhanVien WHERE TenTK =?", username);
        return results.isEmpty() ? null : results.get(0);
    }

    public static NhanVien layThongTinNhanVienTheoEmail(String Email) throws SQLException {
        List<NhanVien> results = executeQuery("SELECT * FROM NhanVien WHERE Email LIKE CONCAT('%', ?, '%')", Email);
        return results.isEmpty() ? null : results.get(0);
    }

    private static List<NhanVien> executeQuery(String query, String parameter) throws SQLException {
        List<NhanVien> dsnv = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, parameter);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    String maNhanVien = resultSet.getString("MaNhanVien");
                    String tenNhanVien = resultSet.getString("TenNhanVien");
                    String sdtNhanVien = resultSet.getString("SdtNV");
                    String emailNhanVien = resultSet.getString("Email");
                    String tenTK = resultSet.getString("TenTK");
                    String matKhau = resultSet.getString("MatKhau");
                    String vaiTro = resultSet.getString("VaiTro");
                    NhanVien nv = new NhanVien(maNhanVien, tenNhanVien, sdtNhanVien, emailNhanVien, tenTK, matKhau, vaiTro);
                    dsnv.add(nv);
                }
            }
        }
        return dsnv;
    }

    
    public static String getValueForQuery(String query, String TenNV, String SdtNV, String EmailNV, String MatKhauNV, String VaiTro, String TaiKhoanNV) {
        if (query.contains("TenNhanVien")) {
            return TenNV;
        } else if (query.contains("SdtNV")) {
            return SdtNV;
        } else if (query.contains("Email")) {
            return EmailNV;
        } else if (query.contains("MatKhau")) {
            return MatKhauNV;
        } else if (query.contains("VaiTro")) {
            return VaiTro;
        } else if (query.contains("TenTK")){
            return TaiKhoanNV;
        }
        return null;
    }

    
    public void xoaNhanVien(String manhanvien) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM NhanVien WHERE MaNhanVien=?");
        preparedStatement.setString(1, manhanvien);
        preparedStatement.executeUpdate();
    }
    
    public void suaNhanVien(String MaNV, String TenNV, String SdtNV, String EmailNV, String TaiKhoanNV, String MatKhauNV, String VaiTro) throws SQLException{
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM NhanVien WHERE MaNhanVien = ?");
        ps.setString(1, MaNV);
        ResultSet rs = ps.executeQuery();

        List<String> updateQueries = new ArrayList<>();
        StringBuilder updateMessage = new StringBuilder();

        if (rs.next()) {
            if (!TenNV.equals("")) {
                updateQueries.add("UPDATE NhanVien SET TenNhanVien = ? WHERE MaNhanVien = ?");
//                updateMessage.append("Cập nhật thành công họ tên nhân viên ").append(MaNV).append("\n");
            }
            if (!SdtNV.equals("")) {
                updateQueries.add("UPDATE NhanVien SET SdtNV = ? WHERE MaNhanVien = ?");
//                updateMessage.append("Cập nhật thành công số điện thoại nhân viên ").append(MaNV).append("\n");
            }
            if (!EmailNV.equals("")) {
                updateQueries.add("UPDATE NhanVien SET Email = ? WHERE MaNhanVien = ?");
//                updateMessage.append("Cập nhật thành công email nhân viên ").append(MaNV).append("\n");
            }
            if (!MatKhauNV.equals("")) {
                updateQueries.add("UPDATE NhanVien SET MatKhau = ? WHERE MaNhanVien = ?");
//                updateMessage.append("Cập nhật thành công mật khẩu nhân viên ").append(MaNV).append("\n");
            }
            if (!VaiTro.equals("")) {
                updateQueries.add("UPDATE NhanVien SET VaiTro = ? WHERE MaNhanVien = ?");
//                updateMessage.append("Cập nhật thành công vai trò nhân viên ").append(MaNV).append("\n");
            }
            if(!TaiKhoanNV.equals("")){
                updateQueries.add("UPDATE NhanVien SET TenTK = ? WHERE MaNhanVien = ?");
//                updateMessage.append("Cập nhật thành công nhân viên ").append(MaNV).append("\n");
            }
            ps.close();

            if (!updateQueries.isEmpty()) {
                for (String query : updateQueries) {
                    ps = conn.prepareStatement(query);
                    ps.setString(1, getValueForQuery(query, TenNV, SdtNV, EmailNV, MatKhauNV, VaiTro, TaiKhoanNV));
                    ps.setString(2, MaNV);
                    ps.executeUpdate();
                }
                JOptionPane.showMessageDialog(null, "Cập nhật nhân viên thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Không có thông tin để cập nhật");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên");
        }


    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }
    
}

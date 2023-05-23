/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;
import model.DatabaseConnect;
import model.KhachHang;

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
    
    public KhachHang timKhachHangBangSDT(String SDT) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM KhachHang WHERE SdtKhachHang=?");
        preparedStatement.setString(1,SDT);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            String MaKH = resultSet.getString("MaKhachHang");
            String hoTenKH = resultSet.getString("HoTenKhachHang");
            KhachHang khachhang = new KhachHang(MaKH,hoTenKH,SDT);
            return khachhang;
        }else{
            return null;
        }
    }
    
    public List<KhachHang> timKhachHangBangTenKH(String HoTenKH) throws SQLException{
        List<KhachHang> dskh = new ArrayList<KhachHang>();
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM KhachHang WHERE HoTenKhachHang=?");
        preparedStatement.setString(1,HoTenKH);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            String maKH = resultSet.getString("MaKhachHang");
            String hoTenKH = resultSet.getString("HoTenKhachHang");
            String SDTKH = resultSet.getString("SdtKhachHang");
            KhachHang khachhang = new KhachHang(maKH,hoTenKH,SDTKH);
            dskh.add(khachhang);
        }
        return dskh;
    }
    
    public void xoaKhachHang(String makhachhang) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM KhachHang WHERE MaKhachHang=?");
        preparedStatement.setString(1, makhachhang);
        preparedStatement.executeUpdate();
    }
    
    public void suaKhachHang(String MaKhachHang, String HoTen, String SDT) throws SQLException{
        //Hàm sửa khách hàng
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM KhachHang WHERE MaKhachHang=?");
        preparedStatement.setString(1, MaKhachHang);
        ResultSet rs = preparedStatement.executeQuery();
            
        if(HoTen.equals("")){
            //Chỉ sửa SDT
            if(rs.next()){
                preparedStatement = conn.prepareStatement("UPDATE KhachHang SET SdtKhachHang = ? WHERE MaKhachHang = ?");
                preparedStatement.setString(1,SDT);
                preparedStatement.setString(2,MaKhachHang);
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Sửa thành công số điện thoại khách hàng " + MaKhachHang, "Thành Công", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Không sửa thành công", "Lỗi", 0);
            }
        }else if(SDT.equals("")){
            //Chỉ sửa HoTen
            if(rs.next()){
                preparedStatement = conn.prepareStatement("UPDATE KhachHang SET HoTenKhachHang = ? WHERE MaKhachHang = ?");
                preparedStatement.setString(1,HoTen);
                preparedStatement.setString(2,MaKhachHang);
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Sửa thành công họ tên khách hàng " + MaKhachHang, "Thành Công", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Không sửa thành công", "Lỗi", 0);
            }
        }else{
            //Sửa HoTen và SDT
            if(rs.next()){
                preparedStatement = conn.prepareStatement("UPDATE KhachHang SET SdtKhachHang = ?, HoTenKhachHang = ? WHERE MaKhachHang = ?");
                preparedStatement.setString(1,SDT);
                preparedStatement.setString(2,HoTen);
                preparedStatement.setString(3,MaKhachHang);
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Sửa thành công thông tin khách hàng " + MaKhachHang, "Thành Công", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Không sửa thành công", "Lỗi", 0);
            }
        }
            
    }
}

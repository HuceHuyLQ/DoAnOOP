/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
import model.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nguyenhuuhieu
 */
public class DangKyController {
    private JFrame_DangKy frm_DangKy = new JFrame_DangKy();
    private static DatabaseConnect db = new DatabaseConnect();
    private static Connection conn = db.Connect();
    
    public DangKyController(JFrame_DangKy frm_DangKy){
        this.frm_DangKy = frm_DangKy;
        frm_DangKy.setVisible(true);
        
        frm_DangKy.getBtn_DangKy().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(frm_DangKy.getTxt_MaNhanVien().getText().equals("") || frm_DangKy.getTxt_HoTen().getText().equals("") || frm_DangKy.getTxt_SDT().getText().equals("") || frm_DangKy.getTxt_Email().getText().equals("") || frm_DangKy.getTxt_TaiKhoan().getText().equals("") || frm_DangKy.getPw_MatKhau().getPassword().equals("") || frm_DangKy.getPw_XacNhanMK().getPassword().equals("")){
                    JOptionPane.showMessageDialog(frm_DangKy, "Vui lòng nhập đầy đủ thông tin!");
                }else{
                    try {
                        String MaNV = frm_DangKy.getTxt_MaNhanVien().getText();
                        String HoTen = frm_DangKy.getTxt_HoTen().getText();
                        String SDT = frm_DangKy.getTxt_SDT().getText();
                        String Email = frm_DangKy.getTxt_Email().getText();
                        String VaiTro = null;
                        String TaiKhoan = frm_DangKy.getTxt_TaiKhoan().getText();
                        char[] MatKhau = frm_DangKy.getPw_MatKhau().getPassword();
                        char[] XacNhanMK = frm_DangKy.getPw_XacNhanMK().getPassword();
                        
                        String strMatKhau = new String(MatKhau);
                        String strXacNhanMK = new String(XacNhanMK);
                        
                        PreparedStatement ps = conn.prepareStatement("INSERT INTO NhanVien(MaNhanVien,TenNhanVien,SdtNV,Email,VaiTro,TenTK,MatKhau) VALUES(?,?,?,?,?,?,?)");
                        ps.setString(1, MaNV);
                        ps.setString(2, HoTen);
                        ps.setString(3, SDT);
                        ps.setString(4, Email);
                        ps.setString(5, null);
                        ps.setString(6, TaiKhoan);
                        ps.setString(7, strMatKhau);
                        
                        if(strMatKhau.equals(strXacNhanMK)){
                            int kq = ps.executeUpdate();
                            if(kq>0){
                                JOptionPane.showMessageDialog(frm_DangKy, "Đăng ký thành công!");
                            }
                        } else{
                            JOptionPane.showMessageDialog(frm_DangKy, "Xác nhận mật khẩu không đúng!");
                        }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(DangKyController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        });
    }
}

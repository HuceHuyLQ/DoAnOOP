/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.*;
import view.*;

/**
 *
 * @author huylequang
 */
public class LoginController {
    private JFrame_Login frm_login = new JFrame_Login();
    private NhanVienDao nhanvien = new NhanVienDao();
    
    public LoginController(JFrame_Login frm_login, NhanVienDao nhanvien) {
        this.frm_login = frm_login;
        this.nhanvien = nhanvien;
        
        frm_login.setVisible(true);
        frm_login.getBtn_DangNhap().addActionListener(new ActionListener(){
            @Override
       
            
            public void actionPerformed(ActionEvent e) {
                String user = frm_login.getTxt_TaiKhoan().getText();
                int usertoCheck = Integer.parseInt(frm_login.getTxt_TaiKhoan().getText());
                String password = new String(frm_login.getPasswordField().getPassword());
                if(user.equals("")&&password.equals("")){
                    frm_login.showMessage("Không được để trống thông tin đăng nhập");
                }else if(user.equals("")){
                    frm_login.showMessage("Không được để trống TÀI KHOẢN!!!");
                }else if(password.equals("")){
                    frm_login.showMessage("Không được để trống MẬT KHẨU!!!");
                }else{
                    try {
                        if(nhanvien.kiemTraDangNhap(usertoCheck,password)){
                            JFrame_Main FormMain = new JFrame_Main();
                            MainFormController mainfrmctrl = new MainFormController(FormMain);
                            frm_login.setVisible(false);
                            try {
                                frm_login.showMessage("Welcome "+nhanvien.layThongTinNhanVien(usertoCheck).getHoTenNV());
                                nhanvien.layThongTinNhanVien(usertoCheck).getHoTenNV();
                            } catch (SQLException ex) {
                                Logger.getLogger(JFrame_Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }else{
                            frm_login.showMessage("Thông tin đăng nhập không đúng");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(JFrame_Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                frm_login.clearForm();
            }
            
        });
        frm_login.getBtn_Huy().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frm_login.clearForm();
            }
            
        });
        frm_login.getBtn_DangKy().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame_DangKy frm_dangky = new JFrame_DangKy();
                frm_dangky.setVisible(true);
            }
        });
    }
    
    
}

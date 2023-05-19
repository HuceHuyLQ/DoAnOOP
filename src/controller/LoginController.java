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
    private MainForm frm_main = new MainForm();
    private NhanVienDao nhanvien = new NhanVienDao();
    
    public LoginController(JFrame_Login frm_login, NhanVienDao nhanvien) {
        this.frm_login = frm_login;
        this.nhanvien = nhanvien;
        
        frm_login.setVisible(true);
        frm_login.getBtn_DangNhap().addActionListener(new ActionListener(){
            @Override
       
            
            public void actionPerformed(ActionEvent e) {
                String user = frm_login.getTxt_TaiKhoan().getText();
                String password = new String(frm_login.getPasswordField().getPassword());
                if(user.equals("")&&password.equals("")){
                    frm_login.showMessage("Không được để trống thông tin đăng nhập");
                }else if(user.equals("")){
                    frm_login.showMessage("Không được để trống TÀI KHOẢN!!!");
                }else if(password.equals("")){
                    frm_login.showMessage("Không được để trống MẬT KHẨU!!!");
                }else{
                    try {
                        if(nhanvien.kiemTraDangNhap(user,password)){
                            frm_login.setVisible(false);
                            getFrm_main().getLbl_Username().setText(nhanvien.getNhanVien().getTenTK());
                            getFrm_main().getLbl_headerMaNV().setText(nhanvien.getNhanVien().getMaNhanVien());
                            getFrm_main().setVisible(true);
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
        frm_login.getBtn_DangKy().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame_DangKy frm_dangky = new JFrame_DangKy();
                frm_dangky.setVisible(true);
            }
        });
    }

    public JFrame_Login getFrm_login() {
        return frm_login;
    }

    public void setFrm_login(JFrame_Login frm_login) {
        this.frm_login = frm_login;
    }

    public NhanVienDao getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVienDao nhanvien) {
        this.nhanvien = nhanvien;
    }

    public MainForm getFrm_main() {
        return frm_main;
    }

    public void setFrm_main(MainForm frm_main) {
        this.frm_main = frm_main;
    }
    
    
}

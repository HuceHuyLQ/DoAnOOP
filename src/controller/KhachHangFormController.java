/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.*;
import model.*;

/**
 *
 * @author huylequang
 */
public class KhachHangFormController {
    JFrame_KhachHang frm_khachhang = new JFrame_KhachHang();
    KhachHangDao khachhangdao = new KhachHangDao();
    public KhachHangFormController(JFrame_KhachHang frm_khachhang, KhachHangDao khachhangdao) {
        this.frm_khachhang = frm_khachhang;
        this.khachhangdao = khachhangdao;
        frm_khachhang.setVisible(true);
        
        frm_khachhang.getBtn_ThemKhachHang().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String makh = frm_khachhang.getTxt_MaKH().toString();
                    String hoten = frm_khachhang.getTxt_TenKhachHang().toString();
                    String sdt = frm_khachhang.getTxt_SDTKhachHang().toString();
                    
                    khachhangdao.themKhachHang(makh, hoten, sdt);
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        });
        
    }
    
    
}

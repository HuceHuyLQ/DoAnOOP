/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
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
        
        
    }
    
    
}

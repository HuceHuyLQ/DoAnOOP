/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import view.*;
import model.*;

/**
 *
 * @author 03qua
 */
public class MainFormController {
    JFrame_Main frm_main = new JFrame_Main();

    public MainFormController(JFrame_Main frm_main) {
        this.frm_main = frm_main;
        
        frm_main.setVisible(true);
        frm_main.getjMenu_KhachHang().addMenuListener(new MenuListener(){
            @Override
            public void menuSelected(MenuEvent e) {
                JFrame_KhachHang frm_khachhang = new JFrame_KhachHang();
                KhachHangDao khachhangdao = new KhachHangDao();
                KhachHangFormController khachhangctrl = new KhachHangFormController(frm_khachhang,khachhangdao);
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void menuCanceled(MenuEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });  
    }
    
    
    
}

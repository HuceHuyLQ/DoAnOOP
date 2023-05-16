/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import view.*;
import model.*;

/**
 *
 * @author huylequang
 */
public class KhachHangFormController {
    MainForm mainForm = new MainForm();
    KhachHangDao khachhangdao = new KhachHangDao();
    DefaultTableModel model = (DefaultTableModel)mainForm.getTbl_KhachHang().getModel();
    private void LoadModel(){
        try {
            model.setRowCount(0);
            List<KhachHang> khachhang = khachhangdao.layDanhSachKhachHang();
            for (KhachHang khachHang : khachhang) {
                Object[] rowData = {khachHang.getMaKH(), khachHang.getHoTenKH(), khachHang.getSDTKH()};
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public KhachHangFormController(MainForm frm_khachhang, KhachHangDao khachhangdao) {
        this.LoadModel();
        this.mainForm = frm_khachhang;
        this.khachhangdao = khachhangdao;
        frm_khachhang.setVisible(true);
        frm_khachhang.getTbl_KhachHang().setModel(model);
        frm_khachhang.getBtn_ThemKhachHang().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String makh = frm_khachhang.getTxt_MaKH().getText();
                    String hoten = frm_khachhang.getTxt_TenKhachHang().getText();
                    String sdt = frm_khachhang.getTxt_SDTKhachHang().getText();
                    khachhangdao.themKhachHang(makh, hoten, sdt);
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                        model.setRowCount(0);
                        List<KhachHang> khachhang = khachhangdao.layDanhSachKhachHang();
                        for (KhachHang khachHang : khachhang) {
                            Object[] rowData = {khachHang.getMaKH(), khachHang.getHoTenKH(), khachHang.getSDTKH()};
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        
        });
        
        frm_khachhang.getTbl_KhachHang().getModel().addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e) {
                if(e.getType() == TableModelEvent.INSERT || e.getType() == TableModelEvent.UPDATE || e.getType() == TableModelEvent.DELETE){
                    try {
                        model.setRowCount(0);
                        List<KhachHang> khachhang = khachhangdao.layDanhSachKhachHang();
                        for (KhachHang khachHang : khachhang) {
                            Object[] rowData = {khachHang.getMaKH(), khachHang.getHoTenKH(), khachHang.getSDTKH()};
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
    }
    
    
}

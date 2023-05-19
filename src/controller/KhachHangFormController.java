/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    private static MainForm mainForm = LoginController.getFrm_main();
    private KhachHangDao khachhangdao = new KhachHangDao();
    private DefaultTableModel model = (DefaultTableModel)mainForm.getTbl_KhachHang().getModel();
    private void updateTable() {
        model = (DefaultTableModel) KhachHangFormController.mainForm.getTbl_KhachHang().getModel();
        
        try {
            model.setRowCount(0);
            List<KhachHang> khachhang = khachhangdao.layDanhSachKhachHang();
            for (KhachHang khachHang : khachhang) {
                Object[] rowData = {khachHang.getMaKH(), khachHang.getHoTenKH(), khachHang.getSDTKH()};
                model.addRow(rowData); // Add a new row to the table model
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public KhachHangFormController(MainForm frm_khachhang) {
        this.updateTable();
        KhachHangFormController.mainForm = frm_khachhang;
        frm_khachhang.setVisible(true);
        frm_khachhang.getTbl_KhachHang().setModel(model);
        
        frm_khachhang.getBtn_ThemKhachHang().addActionListener((ActionEvent e) -> {
            try {
                String makh = frm_khachhang.getTxt_MaKH().getText();
                String hoten = frm_khachhang.getTxt_TenKhachHang().getText();
                String sdt = frm_khachhang.getTxt_SDTKhachHang().getText();
                khachhangdao.themKhachHang(makh, hoten, sdt);
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateTable();
        });
        
        frm_khachhang.getBtn_XoaKhachHang().addActionListener((ActionEvent e) -> {
            int row = frm_khachhang.getTbl_KhachHang().getSelectedRow();
                String cell = frm_khachhang.getTbl_KhachHang().getModel().getValueAt(row, 0).toString();
            int choice = JOptionPane.showConfirmDialog((Component)null,"Xoá khách hàng " + cell + "?","XOÁ",JOptionPane.YES_NO_OPTION);
            System.out.println(choice);
            if(choice == 0){
                try {
                    khachhangdao.xoaKhachHang(cell);
                    JOptionPane.showMessageDialog(null, "Đã xoá khách hàng "+ cell);
                    updateTable();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        
    }
    
    
}

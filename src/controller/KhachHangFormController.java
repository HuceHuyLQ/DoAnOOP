/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import view.*;
import DAO.KhachHangDao;
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
    private void updateTableKH() {
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
    
    private void clearForm(){
        KhachHangFormController.mainForm.getTxt_MaKH().setText("");
        KhachHangFormController.mainForm.getTxt_TenKhachHang().setText("");
        KhachHangFormController.mainForm.getTxt_SDTKhachHang().setText("");
        mainForm.getTxt_MaKH().setEnabled(true);
    }
    
    public KhachHangFormController(MainForm frm_khachhang) {
        this.updateTableKH();
        frm_khachhang.setVisible(true);
        frm_khachhang.getTbl_KhachHang().setModel(model);
        
        // insert
        frm_khachhang.getBtn_ThemKhachHang().addActionListener((ActionEvent e) -> {
            try {
                String makh = frm_khachhang.getTxt_MaKH().getText();
                String hoten = frm_khachhang.getTxt_TenKhachHang().getText();
                String sdt = frm_khachhang.getTxt_SDTKhachHang().getText();
                boolean maTonTai = khachhangdao.kiemTraTonTai(makh);
                if(makh.equals("") || hoten.equals("") || sdt.equals("")){
                    JOptionPane.showMessageDialog(mainForm, "Hãy nhập đầy đủ thông tin!");
                } else if(maTonTai){
                    JOptionPane.showMessageDialog(mainForm, "Mã Khách Hàng đã tồn tại!");
                } else{
                    khachhangdao.themKhachHang(makh, CapitalizeWords.capitalizeWords(hoten), sdt);
                    JOptionPane.showMessageDialog(mainForm, "Thêm khách hàng thành công!");
                    updateTableKH();
                    clearForm();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mainForm, "Không thể thêm khách hàng!");
                Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        // delete
        frm_khachhang.getBtn_XoaKhachHang().addActionListener((ActionEvent e) -> {         
            int row = frm_khachhang.getTbl_KhachHang().getSelectedRow();
            String cell = frm_khachhang.getTbl_KhachHang().getModel().getValueAt(row, 0).toString();
            int choice = JOptionPane.showConfirmDialog((Component)null,"Xoá khách hàng " + cell + "?","XOÁ",JOptionPane.YES_NO_OPTION);
                if(choice == 0){
                    try {
                        khachhangdao.xoaKhachHang(cell);
                        JOptionPane.showMessageDialog(null, "Đã xoá khách hàng "+ cell);
                        updateTableKH();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(mainForm, "Hãy chọn khách hàng cần xoá!");
                        Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            clearForm();
        });
        
        
        // find
        frm_khachhang.getBtn_TimKhachHang().addActionListener((var e) -> {
            String maKh = frm_khachhang.getTxt_MaKH().getText();
            String hoTen = frm_khachhang.getTxt_TenKhachHang().getText();
            String sdt = frm_khachhang.getTxt_SDTKhachHang().getText();
            KhachHang khachHang = null;
            if(maKh.equals("")&&hoTen.equals("")&&sdt.equals("")){
                JOptionPane.showMessageDialog(null, "Không có thông tin để tìm kiếm");
            }else if(hoTen.equals("")&&sdt.equals("")){
                try{
                    khachHang = khachhangdao.timKhachHangBangMaKH(maKh);
                    if(khachHang != null){
                        model = (DefaultTableModel) KhachHangFormController.mainForm.getTbl_KhachHang().getModel();
                        model.setRowCount(0); 
                        Object[] rowData = {khachHang.getMaKH(),khachHang.getHoTenKH(),khachHang.getSDTKH()};
                        model.addRow(rowData);
                    }else{
                        JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã "+maKh);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(maKh.equals("")&&sdt.equals("")){
                try{
                    List<KhachHang> dskh = khachhangdao.timKhachHangBangTenKH(hoTen);
                    if(dskh != null){
                        model.setRowCount(0);
                        for (KhachHang khachHangTheoTen : dskh) {
                            Object[] rowData = {khachHangTheoTen.getMaKH(), khachHangTheoTen.getHoTenKH(), khachHangTheoTen.getSDTKH()};
                            model.addRow(rowData);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Không tìm thấy khách hàng có tên "+hoTen);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
                }      
            }else if(maKh.equals("")&&hoTen.equals("")){
                try{
                    khachHang = khachhangdao.timKhachHangBangSDT(sdt);
                    if(khachHang != null){
                        model = (DefaultTableModel) KhachHangFormController.mainForm.getTbl_KhachHang().getModel();
                        model.setRowCount(0); 
                        Object[] rowData = {khachHang.getMaKH(),khachHang.getHoTenKH(),khachHang.getSDTKH()};
                        model.addRow(rowData);
                    }else{
                        JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có số điện thoại: "+sdt);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            clearForm();
        });
        
        frm_khachhang.getBtn_LayDuLieu().addActionListener((ActionEvent e) -> {
            updateTableKH();
            clearForm();
        });
        
        
        // update
        frm_khachhang.getBtn_SuaKhachHang().addActionListener((ActionEvent e) -> {
            int row = frm_khachhang.getTbl_KhachHang().getSelectedRow();
            String maKh = frm_khachhang.getTbl_KhachHang().getModel().getValueAt(row, 0).toString();
            String hoTen = frm_khachhang.getTxt_TenKhachHang().getText();
            String sdt = frm_khachhang.getTxt_SDTKhachHang().getText();
            try {
                    khachhangdao.suaKhachHang(maKh, CapitalizeWords.capitalizeWords(hoTen), sdt);
                    updateTableKH();
                    clearForm();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mainForm, "Hãy chọn khách hàng cần sửa thông tin!");                
                Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.LuotThue;
import model.Phong;
import view.MainForm;

/**
 *
 * @author nguyenhuuhieu
 */
public class LuotThueFormController {
    private static MainForm mainForm = LoginController.getFrm_main();
    private LuotThueDao luotThueDao = new LuotThueDao();
    private DefaultTableModel model = (DefaultTableModel)mainForm.getTbl_LuotThue().getModel();
    
    private void updateTable() {
        model = (DefaultTableModel) LuotThueFormController.mainForm.getTbl_LuotThue().getModel();
        
        try {
            model.setRowCount(0);
            List<LuotThue> dsLuotThue = luotThueDao.layDanhSachLuotThue();
            for (LuotThue lt : dsLuotThue) {
                Object[] rowData = {lt.getMaLuotThue(), lt.getMaKhachHang(), lt.getMaPhong(), lt.getMaNhanVien(), lt.getNgayGioThue(), lt.getCoc(), lt.getTongTien(), lt.getGhiChu()};
                model.addRow(rowData); // Add a new row to the table model
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clearForm(){
        LuotThueFormController.mainForm.getTxt_MaLuotThue().setText("");
        LuotThueFormController.mainForm.getTxt_MaKHLuotThue().setText("");
        LuotThueFormController.mainForm.getTxt_MaPhongLT().setText("");
        LuotThueFormController.mainForm.getTxt_MaNVLT().setText("");
        LuotThueFormController.mainForm.getTxt_NgayGioLT().setText("");
        LuotThueFormController.mainForm.getTxt_CocLT().setText("");
        LuotThueFormController.mainForm.getTxt_TongTienLT().setText("");
        LuotThueFormController.mainForm.getTxt_GhiChuLT().setText("");
    }
    
    public LuotThueFormController(MainForm frm_LuotThue){
        this.updateTable();
        frm_LuotThue.setVisible(true);
        frm_LuotThue.getTbl_LuotThue().setModel(model);
        
        frm_LuotThue.getBtn_LayDuLieuLuotThue().addActionListener((ActionEvent e) -> {
            this.updateTable();
            clearForm();
        });
        
        // INSERT
        frm_LuotThue.getBtn_ThemLuotThue().addActionListener((ActionEvent e) ->{
            String MaLuotThue = frm_LuotThue.getTxt_MaLuotThue().getText();
            String MaKhachHang = frm_LuotThue.getTxt_MaKHLuotThue().getText();
            String MaPhong = frm_LuotThue.getTxt_MaPhongLT().getText();
            String MaNhanVien = frm_LuotThue.getTxt_MaNVLT().getText();
            String NgayGioThue = frm_LuotThue.getTxt_NgayGioLT().getText();
            double Coc = Double.parseDouble(frm_LuotThue.getTxt_CocLT().getText());
            double TongTien = Double.parseDouble(frm_LuotThue.getTxt_TongTienLT().getText());
            String GhiChu;
            if (frm_LuotThue.getTxt_GhiChuLT().getText().isEmpty()) {
                GhiChu = "";
            } else {
                GhiChu = frm_LuotThue.getTxt_GhiChuLT().getText();
            }
            try {
                boolean maTonTai = luotThueDao.kiemTraTonTai(MaLuotThue);
                if(maTonTai){
                    JOptionPane.showMessageDialog(frm_LuotThue, "Mã Lượt Thuê Đã Tồn Taị!!!");
                }
                luotThueDao.themLuotThue(MaLuotThue, MaKhachHang, MaPhong, MaNhanVien, NgayGioThue, Coc, TongTien, GhiChu);
                JOptionPane.showMessageDialog(null, "Thêm Lượt Thuê Thành Công ");
                updateTable();
                clearForm();
            } catch (SQLException ex) {
                Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Thêm thất bại!!!");
            }
        });
        
        // UPDATE
        frm_LuotThue.getBtn_SuaLuotThue().addActionListener((ActionEvent e) ->{
            String MaLuotThue = frm_LuotThue.getTxt_MaLuotThue().getText();
            String MaKhachHang = frm_LuotThue.getTxt_MaKHLuotThue().getText();
            String MaPhong = frm_LuotThue.getTxt_MaPhongLT().getText();
            String MaNhanVien = frm_LuotThue.getTxt_MaNVLT().getText();
            String NgayGioThue = frm_LuotThue.getTxt_NgayGioLT().getText();
            double Coc = Double.parseDouble(frm_LuotThue.getTxt_CocLT().getText());
            double TongTien = Double.parseDouble(frm_LuotThue.getTxt_TongTienLT().getText());
            String GhiChu;
            if (frm_LuotThue.getTxt_GhiChuLT().getText().isEmpty()) {
                GhiChu = "";
            } else {
                GhiChu = frm_LuotThue.getTxt_GhiChuLT().getText();
            }
            try {
                if (!luotThueDao.kiemTraTonTai(MaLuotThue)) {
                    JOptionPane.showMessageDialog(null, "Mã Lượt Thuê không tồn tại!");
                }
                LuotThue luotThueCu = luotThueDao.timLuotThueTheoMa(MaLuotThue); // Lấy thông tin lượt thuê cũ
                if (!luotThueCu.getMaLuotThue().equals(MaLuotThue)) {
                    JOptionPane.showMessageDialog(null, "Không được sửa Mã Lượt Thuê!");
                }
                luotThueDao.suaLuotThue(MaLuotThue, MaKhachHang, MaPhong, MaNhanVien, NgayGioThue, Coc, TongTien, GhiChu);
                updateTable();
                clearForm();
            } catch (SQLException ex) {
                Logger.getLogger(LuotThueFormController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(frm_LuotThue, "That bai");
            }
            updateTable();
            clearForm();
        });
        
        // DELETE
        frm_LuotThue.getBtn_XoaLuotThue().addActionListener((ActionEvent e) ->{
            int row = frm_LuotThue.getTbl_LuotThue().getSelectedRow();
            String cell = frm_LuotThue.getTbl_LuotThue().getModel().getValueAt(row, 0).toString();
            int choice = JOptionPane.showConfirmDialog((Component)null,"Xoá phòng " + cell + "?","XOÁ",JOptionPane.YES_NO_OPTION);
            if(choice == 0){
                try{
                    luotThueDao.xoaLuotThue(cell);
                    JOptionPane.showMessageDialog(null, "Xóa thành công phòng "+cell);
                    updateTable();
                }catch(SQLException ex){
                    Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            clearForm();
        });
        
        //SEARCH
        frm_LuotThue.getBtn_TimluotThue().addActionListener((ActionEvent e) ->{
            String MaLuotThue = frm_LuotThue.getTxt_MaLuotThue().getText();
            LuotThue lt = null;
            if(MaLuotThue.equals("")){
                JOptionPane.showMessageDialog(null, "Không có thông tin để tìm kiếm. Vui lòng nhập Mã Lượt Thuê để tìm kiếm");
            }else {
                try{
                    lt = luotThueDao.timLuotThueTheoMa(MaLuotThue);
                    if(lt != null){
                        model = (DefaultTableModel) LuotThueFormController.mainForm.getTbl_LuotThue().getModel();
                        model.setRowCount(0); 
                        Object[] rowData = {lt.getMaLuotThue(),lt.getMaKhachHang(),lt.getMaPhong(),lt.getMaNhanVien(),lt.getNgayGioThue(),lt.getCoc(),lt.getTongTien(),lt.getGhiChu()};
                        model.addRow(rowData);
                    }else{
                        JOptionPane.showMessageDialog(null, "Không tìm thấy Lượt Thuê có mã "+MaLuotThue);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }
    
    
}

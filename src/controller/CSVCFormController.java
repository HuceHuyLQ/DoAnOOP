/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.CSVCDao;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.CSVC;
import view.MainForm;

/**
 *
 * @author DucHieu
 */
public class CSVCFormController {
    private static MainForm mainForm = LoginController.getFrm_main();
    private CSVCDao csvcdao = new CSVCDao();
    private DefaultTableModel model = (DefaultTableModel)mainForm.getTbl_CSVC().getModel();
    
    private void updateTable() {
        model = (DefaultTableModel) CSVCFormController.mainForm.getTbl_CSVC().getModel();
        
        try {
            model.setRowCount(0);
            List<CSVC> dsCSVC = csvcdao.layDanhSachCSVC();
            for (CSVC csvc : dsCSVC) {
                Object[] rowData = {csvc.getMaCSVC(), csvc.getTenVatTu(), csvc.getGiaCSVC(), csvc.getGhiChuCSVC() };
                model.addRow(rowData); // Add a new row to the table model
            }
        } catch (SQLException ex) {
            Logger.getLogger(CSVCFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private void clearForm(){
        CSVCFormController.mainForm.getTxt_GiaCSVC().setText("");
        CSVCFormController.mainForm.getTxt_GhiChuCSVC().setText("");
        CSVCFormController.mainForm.getTxt_TenVatTu().setText("");
        CSVCFormController.mainForm.getTxt_MaCSVC().setText("");
        
    }
    
    public CSVCFormController(MainForm frm_CSVC) {
        this.updateTable();
        frm_CSVC.setVisible(true);
        frm_CSVC.getTbl_CSVC().setModel(model);
        
        //Load Data Button
        frm_CSVC.getBtn_LayDuLieuCSVC().addActionListener((ActionEvent e) -> {
            this.updateTable();
            clearForm();
        });
        
        //Add Button
        frm_CSVC.getBtn_ThemCSVC().addActionListener((ActionEvent e) ->{
            String MaCSVC = frm_CSVC.getTxt_MaCSVC().getText();
            String TenVatTu = frm_CSVC.getTxt_TenVatTu().getText();
            Double GiaCSVC = Double.parseDouble(frm_CSVC.getTxt_GiaCSVC().getText());
            String GhiChuCSVC = frm_CSVC.getTxt_GhiChuCSVC().getText();
            try {
                csvcdao.themCSVC(MaCSVC, TenVatTu, GiaCSVC, GhiChuCSVC);
                JOptionPane.showMessageDialog(null, "Thêm thành công CSVC " + MaCSVC);
                this.updateTable();
            } catch (SQLException ex) {
                Logger.getLogger(CSVCFormController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Thêm thất bại csvc " + MaCSVC);
            }
            clearForm();
        });
        
        frm_CSVC.getBtn_SuaCSVC().addActionListener((ActionEvent e) -> {
            int row = frm_CSVC.getTbl_CSVC().getSelectedRow();
            String maCSVC = frm_CSVC.getTbl_CSVC().getModel().getValueAt(row, 0).toString();
            String tenVatTu = frm_CSVC.getTxt_TenVatTu().getText();
            double giaCSVC;
            String ghiChuCSVC = frm_CSVC.getTxt_GhiChuCSVC().getText();
            if(frm_CSVC.getTxt_GiaCSVC().getText().equals("")){
                giaCSVC = 0;
            }else{
                giaCSVC = Double.valueOf(frm_CSVC.getTxt_GiaCSVC().getText());
            }
            try {
                csvcdao.suaCSVC(maCSVC, tenVatTu, giaCSVC, ghiChuCSVC);
            } catch (SQLException ex) {
                Logger.getLogger(CSVCFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
            updateTable();
            clearForm();
        });
        
        //Delete Button 
        frm_CSVC.getBtn_XoaCSVC().addActionListener((ActionEvent e) -> {
            int row = frm_CSVC.getTbl_CSVC().getSelectedRow();
            String cell = frm_CSVC.getTbl_CSVC().getModel().getValueAt(row, 0).toString();
            int choice = JOptionPane.showConfirmDialog((Component)null,"Xoá CSVC " + cell + "?","XOÁ",JOptionPane.YES_NO_OPTION);
            if(choice == 0){
                try{
                    csvcdao.xoaCSVC(cell);
                    JOptionPane.showMessageDialog(null, "Xóa thành công CSVC "+cell);
                    updateTable();
                }catch(SQLException ex){
                    Logger.getLogger(CSVCFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            clearForm();
        });
        //Search Button
        frm_CSVC.getBtn_TimCSVC().addActionListener((ActionEvent e) -> {
            String maCSVC = frm_CSVC.getTxt_MaCSVC().getText();
            String tenVatTu = frm_CSVC.getTxt_TenVatTu().getText();
            double giaCSVC;
            String ghiChuCSVC = frm_CSVC.getTxt_GhiChuCSVC().getText();
            if(frm_CSVC.getTxt_GiaCSVC().getText().equals("")){
                giaCSVC = 0;
            }else{
                giaCSVC = Double.valueOf(frm_CSVC.getTxt_GiaCSVC().getText());
            }
            CSVC csvc = null;
            if(maCSVC.equals("")&&tenVatTu.equals("")&&giaCSVC==0&&ghiChuCSVC.equals("")){
                JOptionPane.showMessageDialog(null, "Không có thông tin để tìm kiếm");
            }else if(tenVatTu.equals("")&&giaCSVC==0&&ghiChuCSVC.equals("")){
                try{
                    csvc = csvcdao.timCSVCTheoMa(maCSVC);
                    if(csvc != null){
                        model = (DefaultTableModel) CSVCFormController.mainForm.getTbl_CSVC().getModel();
                        model.setRowCount(0); 
                        Object[] rowData = {csvc.getMaCSVC(),csvc.getTenVatTu(),csvc.getGiaCSVC(),csvc.getGhiChuCSVC()};
                        model.addRow(rowData);
                    }else{
                        JOptionPane.showMessageDialog(null, "Không tìm thấy CSVC có mã "+maCSVC);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            clearForm();
        });
    }
}



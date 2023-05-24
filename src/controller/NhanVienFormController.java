/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAO.NhanVienDao;
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
 * @author 03qua
 */
public class NhanVienFormController {
    private static MainForm mainForm = LoginController.getFrm_main();
    private NhanVienDao nvdao = new NhanVienDao();
    private DefaultTableModel model = (DefaultTableModel)mainForm.getTbl_NhanVien().getModel();
    private void updateTable() {
        model = (DefaultTableModel) NhanVienFormController.mainForm.getTbl_NhanVien().getModel();
        
        try {
            model.setRowCount(0);
            List<NhanVien> dsnv = nvdao.layDanhSachNhanVien();
            for (NhanVien nv : dsnv) {
                Object[] rowData = {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getSdtNV(),nv.getEmail(),nv.getTenTK(),nv.getMatKhau(),nv.getVaiTro()};
                model.addRow(rowData); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearForm(){
        mainForm.getTxt_MaNV().setText("");
        mainForm.getTxt_HoTenNV().setText("");
        mainForm.getTxt_SDTNV().setText("");
        mainForm.getTxt_EmailNV().setText("");
        mainForm.getTxt_TaiKhoanNV().setText("");
        mainForm.getTxt_MatKhauNV().setText("");
        mainForm.getTxt_VaiTroNV().setText("");
    }
    
    NhanVienFormController(MainForm mainForm){
        this.mainForm = mainForm;
        updateTable();
        
        mainForm.getBtn_LayDuLieuNhanVien().addActionListener((ActionEvent e)->{
            updateTable();
            clearForm();
        });
        
        mainForm.getBtn_TimNhanVien().addActionListener((ActionEvent e) -> {
            
        });
        
        mainForm.getBtn_ThemNhanVien().addActionListener((ActionEvent e) -> {
            String MaNhanVien = mainForm.getTxt_MaNV().getText();
            String HoTen = mainForm.getTxt_HoTenNV().getText();
            String SDT = mainForm.getTxt_SDTNV().getText();
            String Email = mainForm.getTxt_EmailNV().getText();
            String TaiKhoan = mainForm.getTxt_TaiKhoanNV().getText();
            String MatKhau = mainForm.getTxt_MatKhauNV().getText();
            String VaiTro = mainForm.getTxt_VaiTroNV().getText();
            try {
                nvdao.themNhanVien(MaNhanVien, HoTen, SDT,Email,TaiKhoan,MatKhau,VaiTro);
                JOptionPane.showMessageDialog(null, "Thêm thành công nhân viên" + MaNhanVien);
                this.updateTable();
            } catch (SQLException ex) {
                Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Thêm thất bại nhân viên " + MaNhanVien);
            }
            clearForm();
        });
    }
}

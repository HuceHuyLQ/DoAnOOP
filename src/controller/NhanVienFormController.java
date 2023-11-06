/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import view.*;
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
        mainForm.getTxt_MaNV().setEnabled(true);
        mainForm.getTxt_TaiKhoanNV().setEnabled(true);
    }
    
    NhanVienFormController(MainForm mainForm){
        this.mainForm = mainForm;
        updateTable();
        
        mainForm.getBtn_LayDuLieuNhanVien().addActionListener((ActionEvent e)->{
            updateTable();
            clearForm();
        });
        
        // find
        mainForm.getBtn_TimNhanVien().addActionListener((ActionEvent e) -> {
            String maNV = mainForm.getTxt_MaNV().getText();
            String hotenNV = mainForm.getTxt_HoTenNV().getText();
            String emailNV = mainForm.getTxt_EmailNV().getText();
            String taikhoanNV = mainForm.getTxt_TaiKhoanNV().getText();
            String vaiTroNV = mainForm.getTxt_VaiTroNV().getText();
            
            if(maNV.equals("")&&hotenNV.equals("")&&emailNV.equals("")&&taikhoanNV.equals("")&&vaiTroNV.equals("")){
                JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin tìm kiếm");
            }else if(hotenNV.equals("")&&emailNV.equals("")&&taikhoanNV.equals("")&&vaiTroNV.equals("")){
                try {
                    NhanVien nv = nvdao.layThongTinNhanVienTheoMaNV(maNV);
                    if(nv != null){
                        model = (DefaultTableModel) NhanVienFormController.mainForm.getTbl_NhanVien().getModel();
                        model.setRowCount(0); 
                        Object[] rowData = {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getSdtNV(),nv.getEmail(),nv.getTenTK(),nv.getMatKhau(),nv.getVaiTro()};
                        model.addRow(rowData);
                    }else{
                        JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên có mã "+maNV);
                    }
                }catch (SQLException ex) {
                    Logger.getLogger(NhanVienFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(maNV.equals("")&&emailNV.equals("")&&taikhoanNV.equals("")&&vaiTroNV.equals("")){
                try{
                    List<NhanVien> dsnv = nvdao.timNVTheoTen(hotenNV);
                    if(dsnv != null){
                        model.setRowCount(0);
                        for (NhanVien nv : dsnv) {
                            Object[] rowData = {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getSdtNV(),nv.getEmail(),nv.getTenTK(),nv.getMatKhau(),nv.getVaiTro()};
                            model.addRow(rowData);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Không tìm thấy nhân viên tên "+hotenNV);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(NhanVienFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(maNV.equals("")&&hotenNV.equals("")&&taikhoanNV.equals("")&&vaiTroNV.equals("")){
                try{
                    NhanVien nv = nvdao.layThongTinNhanVienTheoEmail(emailNV);
                    if(nv != null){
                        model = (DefaultTableModel) NhanVienFormController.mainForm.getTbl_NhanVien().getModel();
                        model.setRowCount(0); 
                        Object[] rowData = {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getSdtNV(),nv.getEmail(),nv.getTenTK(),nv.getMatKhau(),nv.getVaiTro()};
                        model.addRow(rowData);
                    }else{
                        JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên có Email "+emailNV);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(NhanVienFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(maNV.equals("")&&hotenNV.equals("")&&emailNV.equals("")&&vaiTroNV.equals("")){
                try{
                    NhanVien nv = nvdao.layThongTinNhanVienTheoUsername(taikhoanNV);
                    if(nv != null){
                        model = (DefaultTableModel) NhanVienFormController.mainForm.getTbl_NhanVien().getModel();
                        model.setRowCount(0); 
                        Object[] rowData = {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getSdtNV(),nv.getEmail(),nv.getTenTK(),nv.getMatKhau(),nv.getVaiTro()};
                        model.addRow(rowData);
                    }else{
                        JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên có tai khoan "+taikhoanNV);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(NhanVienFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(maNV.equals("")&&hotenNV.equals("")&&emailNV.equals("")&&taikhoanNV.equals("")){
                try{
                    List<NhanVien> dsnv = nvdao.timNVVaiTro(vaiTroNV);
                    if(dsnv != null){
                        model.setRowCount(0);
                        for (NhanVien nv : dsnv) {
                            Object[] rowData = {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getSdtNV(),nv.getEmail(),nv.getTenTK(),nv.getMatKhau(),nv.getVaiTro()};
                            model.addRow(rowData);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Không tìm thấy nhân viên có vai trò "+vaiTroNV);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(NhanVienFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        // delete
        mainForm.getBtn_XoaNhanVien().addActionListener((ActionEvent e) -> {
            int row = mainForm.getTbl_NhanVien().getSelectedRow();
            String cell = mainForm.getTbl_NhanVien().getModel().getValueAt(row, 0).toString();
            int choice = JOptionPane.showConfirmDialog((Component)null,"Xoá nhân viên " + cell + "?","XOÁ",JOptionPane.YES_NO_OPTION);
            if(choice == 0){
                try{
                    nvdao.xoaNhanVien(cell);
                    JOptionPane.showMessageDialog(null, "Xóa thành công nhân viên "+cell);
                    updateTable();
                }catch(SQLException ex){
                    Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            clearForm();
        });
        
        
        // insert
        mainForm.getBtn_ThemNhanVien().addActionListener((ActionEvent e) -> {
            String MaNhanVien = mainForm.getTxt_MaNV().getText();
            String HoTen = mainForm.getTxt_HoTenNV().getText();
            String SDT = mainForm.getTxt_SDTNV().getText();
            String Email = mainForm.getTxt_EmailNV().getText();
            String TaiKhoan = mainForm.getTxt_TaiKhoanNV().getText();
            String MatKhau = mainForm.getTxt_MatKhauNV().getText();
            String VaiTro = mainForm.getTxt_VaiTroNV().getText();
            try {
                boolean nncu = nvdao.kiemTraTonTai(MaNhanVien);
                boolean tkcu = nvdao.kiemTraTonTaiTK(TaiKhoan);
                if(MaNhanVien.equals("") || HoTen.equals("") || SDT.equals("") || Email.equals("") || TaiKhoan.equals("") || MatKhau.equals("") || VaiTro.equals("")){
                    JOptionPane.showMessageDialog(mainForm, "Hãy nhập đầy đủ thông tin!");
                } else if(nncu){
                    JOptionPane.showMessageDialog(mainForm, "Mã nhân viên đã tồn tại!");
                } else if(tkcu){
                    JOptionPane.showMessageDialog(mainForm, "Tài khoản đã tồn tại");
                }else{
                    nvdao.themNhanVien(MaNhanVien, CapitalizeWords.capitalizeWords(HoTen), SDT,Email,TaiKhoan,MatKhau,CapitalizeWords.capitalizeWords(VaiTro));
                    JOptionPane.showMessageDialog(null, "Thêm thành công nhân viên" + MaNhanVien);
                    this.updateTable();
                    clearForm();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Thêm thất bại nhân viên " + MaNhanVien);
            }
        });
        
        // update
        mainForm.getBtn_SuaNhanVien().addActionListener((ActionEvent e) -> {
            int row = mainForm.getTbl_NhanVien().getSelectedRow();
            String MaNhanVien = mainForm.getTbl_NhanVien().getModel().getValueAt(row, 0).toString();
            String HoTen = mainForm.getTxt_HoTenNV().getText();
            String SDT = mainForm.getTxt_SDTNV().getText();
            String Email = mainForm.getTxt_EmailNV().getText();
            String TaiKhoan = mainForm.getTxt_TaiKhoanNV().getText();
            String MatKhau = mainForm.getTxt_MatKhauNV().getText();
            String VaiTro = mainForm.getTxt_VaiTroNV().getText();
            try {
                boolean tkcu = nvdao.kiemTraTonTaiTK(TaiKhoan);
                if(tkcu){
                    nvdao.suaNhanVien(MaNhanVien, CapitalizeWords.capitalizeWords(HoTen), SDT,Email,TaiKhoan,MatKhau,CapitalizeWords.capitalizeWords(VaiTro));
                    this.updateTable();
                    clearForm();
                }else{
                    JOptionPane.showMessageDialog(mainForm, "Không thể sửa tên Tài Khoản!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(mainForm, "Không thể sửa");
                Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}

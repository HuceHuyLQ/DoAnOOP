/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.*;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    Phong p = new Phong();
    
    private void updateTable() {
        model = (DefaultTableModel) LuotThueFormController.mainForm.getTbl_LuotThue().getModel();
        
        try {
            model.setRowCount(0);
            List<LuotThue> dsLuotThue = luotThueDao.layDanhSachLuotThue();
            for (LuotThue lt : dsLuotThue) {
                Object[] rowData = {lt.getMaLuotThue(), lt.getMaKhachHang(), lt.getMaPhong(), lt.getMaNhanVien(), lt.getNgayThue(),lt.getGioBatDau(),lt.getGioKetThuc(), lt.getCoc(), lt.getTongTien(), lt.getGhiChu()};
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
        LuotThueFormController.mainForm.getTxt_GioBD().setText("");
        LuotThueFormController.mainForm.getTxt_GioKT().setText("");
        LuotThueFormController.mainForm.getTxt_CocLT().setText("");
        LuotThueFormController.mainForm.getTxt_GhiChuLT().setText("");
        mainForm.getTxt_MaLuotThue().setEnabled(true);
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
            String NgayThue = frm_LuotThue.getTxt_NgayGioLT().getText();
            String GioBatDau = frm_LuotThue.getTxt_GioBD().getText();
            String GioKetThuc = frm_LuotThue.getTxt_GioKT().getText();
            Double Coc;
            String CocTxt = frm_LuotThue.getTxt_Coc().getText();
            if(CocTxt.isEmpty()){
                Coc = null;
            }else{
                Coc =Double.parseDouble(CocTxt);
            }
            double TongTien=0;
            String GhiChu;
            if (frm_LuotThue.getTxt_GhiChuLT().getText().isEmpty()) {
                GhiChu = "";
            } else {
                GhiChu = frm_LuotThue.getTxt_GhiChuLT().getText();
            }
            if(MaLuotThue.equals("") || MaKhachHang.equals("")||MaPhong.equals("")||MaNhanVien.equals("")||NgayThue.equals("")||GioBatDau.equals("")||GioKetThuc.equals("") || Coc.equals("")){
                JOptionPane.showMessageDialog(frm_LuotThue, "Hãy nhập đầy đủ thông tin!");
            } else 
                if(Coc<0){
                JOptionPane.showMessageDialog(frm_LuotThue, "Dữ liệu không phù hợp!");
            } else{ 
                try {
                    boolean maTonTai = luotThueDao.kiemTraTonTai(MaLuotThue);
                    boolean phongTonTai = luotThueDao.kiemTraPhongTonTaiTrongKhoangTG(MaPhong, NgayThue, GioBatDau, GioKetThuc);
                    if(maTonTai){
                        JOptionPane.showMessageDialog(frm_LuotThue, "Mã Lượt Thuê Đã Tồn Taị!!!");
                    } else if(phongTonTai){
                        JOptionPane.showMessageDialog(frm_LuotThue, "Phòng đã tồn tại trong khoảng thời gian này!");
                    }else{
                        luotThueDao.themLuotThue(MaLuotThue, MaKhachHang, MaPhong, MaNhanVien, NgayThue, GioBatDau, GioKetThuc, Coc, TongTien, GhiChu);
                        JOptionPane.showMessageDialog(frm_LuotThue, "Thêm Lượt Thuê Thành Công ");
                        updateTable();
                        clearForm();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LuotThueFormController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Thêm thất bại!!!");
                }
            } 
            
        });
        
        // UPDATE
        frm_LuotThue.getBtn_SuaLuotThue().addActionListener((ActionEvent e) ->{
            String MaLuotThue = frm_LuotThue.getTxt_MaLuotThue().getText();
            String MaKhachHang = frm_LuotThue.getTxt_MaKHLuotThue().getText();
            String MaPhong = frm_LuotThue.getTxt_MaPhongLT().getText();
            String MaNhanVien = frm_LuotThue.getTxt_MaNVLT().getText();
            String NgayThue = frm_LuotThue.getTxt_NgayGioLT().getText();
            String GioBatDau = frm_LuotThue.getTxt_GioBD().getText();
            String GioKetThuc = frm_LuotThue.getTxt_GioKT().getText();
            Double Coc;
            String CocTxt = frm_LuotThue.getTxt_Coc().getText();
            if(CocTxt.isEmpty()){
                Coc = null;
            }else{
                Coc =Double.parseDouble(CocTxt);
            }       
            double TongTien = 0;
            String GhiChu;
            if (frm_LuotThue.getTxt_GhiChuLT().getText().isEmpty()) {
                GhiChu = "";
            } else {
                GhiChu = frm_LuotThue.getTxt_GhiChuLT().getText();
            }           
            if (Coc < 0) {
                JOptionPane.showMessageDialog(frm_LuotThue, "Dữ liệu không phù hợp!");
            } else  {
                try {
                        luotThueDao.suaLuotThuePro(MaLuotThue, MaKhachHang, MaPhong, MaNhanVien, NgayThue, GioBatDau, GioKetThuc, Coc, TongTien, GhiChu);
                        updateTable();
                        clearForm();          
                } catch (SQLException ex) {
                    Logger.getLogger(LuotThueFormController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(frm_LuotThue, "Thất bại!");
                }
            }
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
                    Logger.getLogger(LuotThueFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            clearForm();
        });
        
        //SEARCH
        frm_LuotThue.getBtn_TimluotThue().addActionListener((ActionEvent e) ->{
            String MaLuotThue = frm_LuotThue.getTxt_MaLuotThue().getText();
            String MaKhachHang = frm_LuotThue.getTxt_MaKHLuotThue().getText();
            String MaPhong = frm_LuotThue.getTxt_MaPhongLT().getText();
            String MaNhanVien = frm_LuotThue.getTxt_MaNVLT().getText();
            String NgayThue = frm_LuotThue.getTxt_NgayGioLT().getText();
            if(MaLuotThue.equals("") && MaKhachHang.equals("") && MaPhong.equals("") && MaNhanVien.equals("") && NgayThue.equals("")){
                JOptionPane.showMessageDialog(null, "Không có thông tin để tìm kiếm!");
            }else if(MaKhachHang.equals("") && MaPhong.equals("") && MaNhanVien.equals("") && NgayThue.equals("")){
                try{
                    LuotThue lt = luotThueDao.timLuotThueTheoMa(MaLuotThue);
                    if(lt != null){
                        model = (DefaultTableModel) LuotThueFormController.mainForm.getTbl_LuotThue().getModel();
                        model.setRowCount(0); 
                        Object[] rowData = {lt.getMaLuotThue(),lt.getMaKhachHang(),lt.getMaPhong(),lt.getMaNhanVien(),lt.getNgayThue(),lt.getGioBatDau(),lt.getGioKetThuc(),lt.getCoc(),lt.getTongTien(),lt.getGhiChu()};
                        model.addRow(rowData);
                    }else{
                        JOptionPane.showMessageDialog(null, "Không tìm thấy Lượt Thuê có mã "+MaLuotThue);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(LuotThueFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(MaLuotThue.equals("") && MaPhong.equals("") && MaNhanVien.equals("") && NgayThue.equals("")){
                try{
                    List<LuotThue> luotThueList = luotThueDao.timLuotThueTheoMaKH(MaKhachHang);
                    if (!luotThueList.isEmpty()) {
                        model = (DefaultTableModel) LuotThueFormController.mainForm.getTbl_LuotThue().getModel();
                        model.setRowCount(0);

                        for (LuotThue lt : luotThueList) {
                            Object[] rowData = {lt.getMaLuotThue(), lt.getMaKhachHang(), lt.getMaPhong(), lt.getMaNhanVien(), lt.getNgayThue(), lt.getGioBatDau(), lt.getGioKetThuc(), lt.getCoc(), lt.getTongTien(), lt.getGhiChu()};
                            model.addRow(rowData);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy Lượt Thuê !");
                    }
                }catch(SQLException ex){
                    Logger.getLogger(LuotThueFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(MaLuotThue.equals("") && MaKhachHang.equals("") && MaNhanVien.equals("") && NgayThue.equals("")){
                try{
                    List<LuotThue> luotThueList = luotThueDao.timLuotThueTheoMaP(MaPhong);
                    if (!luotThueList.isEmpty()) {
                        model = (DefaultTableModel) LuotThueFormController.mainForm.getTbl_LuotThue().getModel();
                        model.setRowCount(0);

                        for (LuotThue lt : luotThueList) {
                            Object[] rowData = {lt.getMaLuotThue(), lt.getMaKhachHang(), lt.getMaPhong(), lt.getMaNhanVien(), lt.getNgayThue(), lt.getGioBatDau(), lt.getGioKetThuc(), lt.getCoc(), lt.getTongTien(), lt.getGhiChu()};
                            model.addRow(rowData);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy Lượt Thuê !");
                    }
                }catch(SQLException ex){
                    Logger.getLogger(LuotThueFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(MaLuotThue.equals("") && MaKhachHang.equals("") && MaPhong.equals("") && NgayThue.equals("")){
                try{
                    List<LuotThue> luotThueList = luotThueDao.timLuotThueTheoMaNV(MaNhanVien);
                    if (!luotThueList.isEmpty()) {
                        model = (DefaultTableModel) LuotThueFormController.mainForm.getTbl_LuotThue().getModel();
                        model.setRowCount(0);

                        for (LuotThue lt : luotThueList) {
                            Object[] rowData = {lt.getMaLuotThue(), lt.getMaKhachHang(), lt.getMaPhong(), lt.getMaNhanVien(), lt.getNgayThue(), lt.getGioBatDau(), lt.getGioKetThuc(), lt.getCoc(), lt.getTongTien(), lt.getGhiChu()};
                            model.addRow(rowData);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy Lượt Thuê !");
                    }
                }catch(SQLException ex){
                    Logger.getLogger(LuotThueFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if(MaLuotThue.equals("") && MaKhachHang.equals("") && MaPhong.equals("") && MaNhanVien.equals("")){
                try{
                    List<LuotThue> luotThueList = luotThueDao.timLuotThueTheoNgayThue(NgayThue);
                    if (!luotThueList.isEmpty()) {
                        model = (DefaultTableModel) LuotThueFormController.mainForm.getTbl_LuotThue().getModel();
                        model.setRowCount(0);

                        for (LuotThue lt : luotThueList) {
                            Object[] rowData = {lt.getMaLuotThue(), lt.getMaKhachHang(), lt.getMaPhong(), lt.getMaNhanVien(), lt.getNgayThue(), lt.getGioBatDau(), lt.getGioKetThuc(), lt.getCoc(), lt.getTongTien(), lt.getGhiChu()};
                            model.addRow(rowData);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy Lượt Thuê !");
                    }
                }catch(SQLException ex){
                    Logger.getLogger(LuotThueFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
        });  
    } 
}

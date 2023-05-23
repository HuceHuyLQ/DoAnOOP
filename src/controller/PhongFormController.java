/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAO.PhongDao;
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
public class PhongFormController {
    private static MainForm mainForm = LoginController.getFrm_main();
    private PhongDao phongdao = new PhongDao();
    private DefaultTableModel model = (DefaultTableModel)mainForm.getTbl_PhongHop().getModel();
    private void updateTable() {
        model = (DefaultTableModel) PhongFormController.mainForm.getTbl_PhongHop().getModel();
        
        try {
            model.setRowCount(0);
            List<Phong> dsPhong = phongdao.layDanhSachPhong();
            for (Phong phong : dsPhong) {
                Object[] rowData = {phong.getMaPhong(), phong.getLoaiPhong(), phong.getGiaThue()};
                model.addRow(rowData); // Add a new row to the table model
            }
        } catch (SQLException ex) {
            Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PhongFormController(MainForm frm_Phong) {
        this.updateTable();
        frm_Phong.setVisible(true);
        frm_Phong.getTbl_PhongHop().setModel(model);
        
        //Load Data Button
        frm_Phong.getBtn_LayDuLieuPhong().addActionListener((ActionEvent e) -> {
            this.updateTable();
        });
        
        //Add Button
        frm_Phong.getBtn_ThemPhong().addActionListener((ActionEvent e) ->{
            String MaPhong = frm_Phong.getTxt_MaPhong().getText();
            String LoaiPhong = frm_Phong.getTxt_LoaiPhong().getText();
            Float GiaThue = Float.parseFloat(frm_Phong.getTxt_GiaTien().getText());
            try {
                phongdao.themPhong(MaPhong, LoaiPhong, GiaThue);
                JOptionPane.showMessageDialog(null, "Thêm thành công phòng " + MaPhong);
                this.updateTable();
            } catch (SQLException ex) {
                Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Thêm thất bại phòng " + MaPhong);
            }
        });
        //Delete Button 
        frm_Phong.getBtn_XoaPhong().addActionListener((ActionEvent e) -> {
            int row = frm_Phong.getTbl_PhongHop().getSelectedRow();
            String cell = frm_Phong.getTbl_PhongHop().getModel().getValueAt(row, 0).toString();
            int choice = JOptionPane.showConfirmDialog((Component)null,"Xoá phòng " + cell + "?","XOÁ",JOptionPane.YES_NO_OPTION);
            if(choice == 0){
                try{
                    phongdao.xoaPhong(cell);
                    JOptionPane.showMessageDialog(null, "Xóa thành công phòng "+cell);
                }catch(SQLException ex){
                    Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        //Search Button
        frm_Phong.getBtn_TimPhong().addActionListener((ActionEvent e) -> {
            String maPhong = frm_Phong.getTxt_MaPhong().getText();
            String loaiPhong = frm_Phong.getTxt_LoaiPhong().getText();
            float giaThue;
            if(frm_Phong.getTxt_GiaTien().getText().equals("")){
                giaThue = 0;
            }else{
                giaThue = Float.valueOf(frm_Phong.getTxt_GiaTien().getText());
            }
            Phong phong = null;
            if(maPhong.equals("")&&loaiPhong.equals("")&&giaThue==0){
                JOptionPane.showMessageDialog(null, "Không có thông tin để tìm kiếm");
            }else if(loaiPhong.equals("")&&giaThue==0){
                try{
                    phong = phongdao.timPhongTheoMa(maPhong);
                    if(phong != null){
                        model = (DefaultTableModel) PhongFormController.mainForm.getTbl_PhongHop().getModel();
                        model.setRowCount(0); 
                        Object[] rowData = {phong.getMaPhong(),phong.getLoaiPhong(),phong.getGiaThue()};
                        model.addRow(rowData);
                    }else{
                        JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng có mã "+maPhong);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(KhachHangFormController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(maPhong.equals("")&&giaThue==0){
                try{
                    List<Phong> dsp = phongdao.timPhongTheoLoaiPhong(loaiPhong);
                    if(dsp != null){
                        model.setRowCount(0);
                        for (Phong phongtheoloai : dsp) {
                            Object[] rowData = {phongtheoloai.getMaPhong(), phongtheoloai.getLoaiPhong(), phongtheoloai.getGiaThue()};
                            model.addRow(rowData);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Không tìm thấy phòng loại "+loaiPhong);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
                }      
            }else if(maPhong.equals("")&&loaiPhong.equals("")){
                try{
                    List<Phong> dsp = phongdao.timPhongTheoGiaTien(giaThue);
                    if(dsp != null){
                        model.setRowCount(0);
                        for (Phong phongtheogia : dsp) {
                            Object[] rowData = {phongtheogia.getMaPhong(), phongtheogia.getLoaiPhong(), phongtheogia.getGiaThue()};
                            model.addRow(rowData);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"Không tìm thấy phòng có giá "+giaThue);
                    }
                }catch(SQLException ex){
                    Logger.getLogger(PhongFormController.class.getName()).log(Level.SEVERE, null, ex);
                }     
            }
        });
    } 
}

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
    
    NhanVienFormController(MainForm mainForm){
        this.mainForm = mainForm;
        updateTable();
    }
}

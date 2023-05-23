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
        this.mainForm = frm_Phong;
        this.updateTable();
        mainForm.setVisible(true);
        mainForm.getTbl_PhongHop().setModel(model);
    }
    
}

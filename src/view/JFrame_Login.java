/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;
import model.*;
import javax.swing.*;

/**
 *
 * @author huylequang
 */
public class JFrame_Login extends javax.swing.JFrame {
    DatabaseConnect DBConnect = new DatabaseConnect();
    JFrame frame = new JFrame();
    /**
     * Creates new form JFrame_Login
     */
    public JFrame_Login() {
        setTitle("Hệ Thống Quản Lý Phòng Họp | Đăng Nhập");
        this.setLocationRelativeTo(null);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_TieuDeDangNhap = new javax.swing.JLabel();
        lbl_TaiKhoan = new javax.swing.JLabel();
        lbl_MatKhau = new javax.swing.JLabel();
        txt_TaiKhoan = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        btn_DangNhap = new javax.swing.JButton();
        btn_Huy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_TieuDeDangNhap.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lbl_TieuDeDangNhap.setText("ĐĂNG NHẬP HỆ THỐNG");

        lbl_TaiKhoan.setText("TÀI KHOẢN:");

        lbl_MatKhau.setText("MẬT KHẨU:");

        btn_DangNhap.setText("ĐĂNG NHẬP");
        btn_DangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangNhapActionPerformed(evt);
            }
        });

        btn_Huy.setText("HUỶ");
        btn_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(btn_DangNhap)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_MatKhau)
                            .addComponent(lbl_TaiKhoan))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_TieuDeDangNhap)
                                .addGap(0, 77, Short.MAX_VALUE))
                            .addComponent(txt_TaiKhoan)
                            .addComponent(passwordField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lbl_TieuDeDangNhap)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_TaiKhoan)
                    .addComponent(txt_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_MatKhau)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_DangNhap)
                    .addComponent(btn_Huy))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HuyActionPerformed
        // TODO add your handling code here:
        this.txt_TaiKhoan.setText("");
        this.passwordField.setText("");
    }//GEN-LAST:event_btn_HuyActionPerformed

    private void btn_DangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangNhapActionPerformed
        // TODO add your handling code here:
        String user = this.txt_TaiKhoan.getText();
        String password = this.passwordField.getText();
        if(this.txt_TaiKhoan.getText().equals("")&&this.passwordField.getText().equals("")){
            JOptionPane.showMessageDialog(frame,"Không được để trống thông tin đăng nhập");
        }else if(this.txt_TaiKhoan.getText().equals("")){
            JOptionPane.showMessageDialog(frame,"Không được để trống TÀI KHOẢN!!!");
        }else if(this.passwordField.getText().equals("")){
            JOptionPane.showMessageDialog(frame, "Không được để trống MẬT KHẨU!!!");
        }else{
            if(DBConnect.Connect(user, password)){
                JFrame_Main FormMain = new JFrame_Main();
                FormMain.setVisible(true);
                this.setVisible(false);
            }else{
               JOptionPane.showMessageDialog(frame, "Thông tin đăng nhập không đúng");
            }
        }
        
    }//GEN-LAST:event_btn_DangNhapActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DangNhap;
    private javax.swing.JButton btn_Huy;
    private javax.swing.JLabel lbl_MatKhau;
    private javax.swing.JLabel lbl_TaiKhoan;
    private javax.swing.JLabel lbl_TieuDeDangNhap;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField txt_TaiKhoan;
    // End of variables declaration//GEN-END:variables
}

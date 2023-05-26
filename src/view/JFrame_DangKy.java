
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class JFrame_DangKy extends javax.swing.JFrame {

 
    public JFrame_DangKy() {
        initComponents();
        this.setTitle("Đăng ký");
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_Logo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbl_Title = new javax.swing.JLabel();
        lbl_MaNhanVien = new javax.swing.JLabel();
        txt_MaNhanVien = new javax.swing.JTextField();
        lbl_HoTen = new javax.swing.JLabel();
        txt_HoTen = new javax.swing.JTextField();
        lbl_SDT = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        lbl_Email = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        lbl_TaiKhoan = new javax.swing.JLabel();
        txt_TaiKhoan = new javax.swing.JTextField();
        lbl_MatKhau = new javax.swing.JLabel();
        pw_MatKhau = new javax.swing.JPasswordField();
        lbl_XacNhan = new javax.swing.JLabel();
        pw_XacNhanMK = new javax.swing.JPasswordField();
        lbl_DaCoTK = new javax.swing.JLabel();
        Btn_DangKy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 42, 92));

        lbl_Logo.setFont(new java.awt.Font("Showcard Gothic", 0, 24)); // NOI18N
        lbl_Logo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logonuce.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("copyright © HuyLQ All rights reserved");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(lbl_Logo)))
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(lbl_Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(54, 54, 54))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 500);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbl_Title.setBackground(new java.awt.Color(0, 42, 92));
        lbl_Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_Title.setForeground(new java.awt.Color(0, 42, 92));
        lbl_Title.setText("Đăng Ký");

        lbl_MaNhanVien.setBackground(new java.awt.Color(102, 102, 102));
        lbl_MaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_MaNhanVien.setText("Mã Nhân Viên:");

        txt_MaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_MaNhanVien.setForeground(new java.awt.Color(102, 102, 102));

        lbl_HoTen.setBackground(new java.awt.Color(102, 102, 102));
        lbl_HoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_HoTen.setText("Họ Tên:");

        txt_HoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_HoTen.setForeground(new java.awt.Color(102, 102, 102));

        lbl_SDT.setBackground(new java.awt.Color(102, 102, 102));
        lbl_SDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_SDT.setText("Số Điện Thoại:");

        txt_SDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SDTActionPerformed(evt);
            }
        });

        lbl_Email.setText("Email:");

        lbl_TaiKhoan.setText("Tài Khoản:");

        lbl_MatKhau.setText("Mật Khẩu:");

        pw_MatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pw_MatKhau.setForeground(new java.awt.Color(102, 102, 102));

        lbl_XacNhan.setText("Xác Nhận Mật Khẩu:");

        lbl_DaCoTK.setText("Đã có tài khoản");

        Btn_DangKy.setBackground(new java.awt.Color(0, 42, 92));
        Btn_DangKy.setForeground(new java.awt.Color(255, 255, 255));
        Btn_DangKy.setText("Đăng Ký");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(lbl_Title))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lbl_DaCoTK)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btn_DangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121))
                            .addComponent(lbl_MatKhau)
                            .addComponent(lbl_TaiKhoan)
                            .addComponent(lbl_MaNhanVien)
                            .addComponent(txt_MaNhanVien)
                            .addComponent(lbl_HoTen)
                            .addComponent(txt_HoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                            .addComponent(lbl_SDT)
                            .addComponent(pw_MatKhau)
                            .addComponent(lbl_Email)
                            .addComponent(txt_SDT)
                            .addComponent(txt_Email)
                            .addComponent(lbl_XacNhan)
                            .addComponent(txt_TaiKhoan)
                            .addComponent(pw_XacNhanMK))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Title)
                .addGap(4, 4, 4)
                .addComponent(lbl_MaNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_MaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_HoTen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_SDT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_Email)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_TaiKhoan)
                .addGap(5, 5, 5)
                .addComponent(txt_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(lbl_MatKhau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pw_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_XacNhan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pw_XacNhanMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_DangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_DaCoTK))
                .addGap(31, 31, 31))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtn_DangKy() {
        return Btn_DangKy;
    }

    public void setBtn_DangKy(JButton Btn_DangKy) {
        this.Btn_DangKy = Btn_DangKy;
    }

    public JLabel getLbl_DaCoTK() {
        return lbl_DaCoTK;
    }

    public void setLbl_DaCoTK(JLabel lbl_DaCoTK) {
        this.lbl_DaCoTK = lbl_DaCoTK;
    }

    public JLabel getLbl_Email() {
        return lbl_Email;
    }

    public void setLbl_Email(JLabel lbl_Email) {
        this.lbl_Email = lbl_Email;
    }

    public JLabel getLbl_HoTen() {
        return lbl_HoTen;
    }

    public void setLbl_HoTen(JLabel lbl_HoTen) {
        this.lbl_HoTen = lbl_HoTen;
    }

    public JLabel getLbl_Logo() {
        return lbl_Logo;
    }

    public void setLbl_Logo(JLabel lbl_Logo) {
        this.lbl_Logo = lbl_Logo;
    }

    public JLabel getLbl_MaNhanVien() {
        return lbl_MaNhanVien;
    }

    public void setLbl_MaNhanVien(JLabel lbl_MaNhanVien) {
        this.lbl_MaNhanVien = lbl_MaNhanVien;
    }

    public JLabel getLbl_MatKhau() {
        return lbl_MatKhau;
    }

    public void setLbl_MatKhau(JLabel lbl_MatKhau) {
        this.lbl_MatKhau = lbl_MatKhau;
    }

    public JLabel getLbl_SDT() {
        return lbl_SDT;
    }

    public void setLbl_SDT(JLabel lbl_SDT) {
        this.lbl_SDT = lbl_SDT;
    }

    public JLabel getLbl_TaiKhoan() {
        return lbl_TaiKhoan;
    }

    public void setLbl_TaiKhoan(JLabel lbl_TaiKhoan) {
        this.lbl_TaiKhoan = lbl_TaiKhoan;
    }

    public JLabel getLbl_Title() {
        return lbl_Title;
    }

    public void setLbl_Title(JLabel lbl_Title) {
        this.lbl_Title = lbl_Title;
    }

    public JLabel getLbl_XacNhan() {
        return lbl_XacNhan;
    }

    public void setLbl_XacNhan(JLabel lbl_XacNhan) {
        this.lbl_XacNhan = lbl_XacNhan;
    }

    public JPasswordField getPw_MatKhau() {
        return pw_MatKhau;
    }

    public void setPw_MatKhau(JPasswordField pw_MatKhau) {
        this.pw_MatKhau = pw_MatKhau;
    }

    public JPasswordField getPw_XacNhanMK() {
        return pw_XacNhanMK;
    }

    public void setPw_XacNhanMK(JPasswordField pw_XacNhanMK) {
        this.pw_XacNhanMK = pw_XacNhanMK;
    }

    public JTextField getTxt_Email() {
        return txt_Email;
    }

    public void setTxt_Email(JTextField txt_Email) {
        this.txt_Email = txt_Email;
    }

    public JTextField getTxt_HoTen() {
        return txt_HoTen;
    }

    public void setTxt_HoTen(JTextField txt_HoTen) {
        this.txt_HoTen = txt_HoTen;
    }

    public JTextField getTxt_MaNhanVien() {
        return txt_MaNhanVien;
    }

    public void setTxt_MaNhanVien(JTextField txt_MaNhanVien) {
        this.txt_MaNhanVien = txt_MaNhanVien;
    }

    public JTextField getTxt_SDT() {
        return txt_SDT;
    }

    public void setTxt_SDT(JTextField txt_SDT) {
        this.txt_SDT = txt_SDT;
    }

    public JTextField getTxt_TaiKhoan() {
        return txt_TaiKhoan;
    }

    public void setTxt_TaiKhoan(JTextField txt_TaiKhoan) {
        this.txt_TaiKhoan = txt_TaiKhoan;
    }
    
    
    
    private void txt_SDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SDTActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_DangKy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl_DaCoTK;
    private javax.swing.JLabel lbl_Email;
    private javax.swing.JLabel lbl_HoTen;
    private javax.swing.JLabel lbl_Logo;
    private javax.swing.JLabel lbl_MaNhanVien;
    private javax.swing.JLabel lbl_MatKhau;
    private javax.swing.JLabel lbl_SDT;
    private javax.swing.JLabel lbl_TaiKhoan;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JLabel lbl_XacNhan;
    private javax.swing.JPasswordField pw_MatKhau;
    private javax.swing.JPasswordField pw_XacNhanMK;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_HoTen;
    private javax.swing.JTextField txt_MaNhanVien;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_TaiKhoan;
    // End of variables declaration//GEN-END:variables
}

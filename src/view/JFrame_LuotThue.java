
package view;

public class JFrame_LuotThue extends javax.swing.JFrame {

    public JFrame_LuotThue() {
        setTitle("Quản Lý Lượt Thuê");
        setResizable(false);
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

        lbl_MaLuotThue = new javax.swing.JLabel();
        txt_MaLuotThue = new javax.swing.JTextField();
        lbl_MaKhachHang = new javax.swing.JLabel();
        txt_MaKhachHang = new javax.swing.JTextField();
        lbl_NgayGioThue = new javax.swing.JLabel();
        txt_NgayGioThue = new javax.swing.JTextField();
        lbl_Coc = new javax.swing.JLabel();
        lbl_TongTien = new javax.swing.JLabel();
        txt_Coc = new javax.swing.JTextField();
        lbl_GhiChu = new javax.swing.JLabel();
        txt_GhiChu = new javax.swing.JTextField();
        txt_TongTien = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_LuotThue = new javax.swing.JTable();
        btn_ThemLuotThue = new javax.swing.JButton();
        btn_SuaLuotThue = new javax.swing.JButton();
        btn_XoaLuotThue = new javax.swing.JButton();
        btn_TimLuotThue = new javax.swing.JButton();
        lbl_DanhSachLuotThue = new javax.swing.JLabel();

        lbl_MaLuotThue.setText("Mã Lượt Thuê");

        lbl_MaKhachHang.setText("Mã Khách Hàng");

        lbl_NgayGioThue.setText("Ngày Giờ Thuê");

        lbl_Coc.setText("Cọc");

        lbl_TongTien.setText("Tổng Tiền");

        lbl_GhiChu.setText("Ghi Chú:");

        tbl_LuotThue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Lượt Thuê", "Mã Khách Hàng", "Ngày Giờ Thuê", "Ghi Chú", "Cọc", "Tổng Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_LuotThue);

        btn_ThemLuotThue.setText("Thêm");

        btn_SuaLuotThue.setText("Sửa");

        btn_XoaLuotThue.setText("Xóa");

        btn_TimLuotThue.setText("Tìm");

        lbl_DanhSachLuotThue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_DanhSachLuotThue.setText("Danh Sách Lượt Thuê");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1063, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_Coc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_NgayGioThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_MaLuotThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_MaLuotThue, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                            .addComponent(txt_NgayGioThue)
                            .addComponent(txt_Coc))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_MaKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_GhiChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_TongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_GhiChu)
                            .addComponent(txt_MaKhachHang)
                            .addComponent(txt_TongTien)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_DanhSachLuotThue)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_ThemLuotThue)
                                .addGap(18, 18, 18)
                                .addComponent(btn_SuaLuotThue)
                                .addGap(18, 18, 18)
                                .addComponent(btn_XoaLuotThue)
                                .addGap(18, 18, 18)
                                .addComponent(btn_TimLuotThue)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_MaLuotThue)
                    .addComponent(txt_MaLuotThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_MaKhachHang)
                    .addComponent(txt_MaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_NgayGioThue)
                    .addComponent(txt_NgayGioThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_GhiChu)
                    .addComponent(txt_GhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Coc)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Coc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_TongTien)
                        .addComponent(txt_TongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThemLuotThue)
                    .addComponent(btn_SuaLuotThue)
                    .addComponent(btn_XoaLuotThue)
                    .addComponent(btn_TimLuotThue))
                .addGap(18, 18, 18)
                .addComponent(lbl_DanhSachLuotThue)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_SuaLuotThue;
    private javax.swing.JButton btn_ThemLuotThue;
    private javax.swing.JButton btn_TimLuotThue;
    private javax.swing.JButton btn_XoaLuotThue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Coc;
    private javax.swing.JLabel lbl_DanhSachLuotThue;
    private javax.swing.JLabel lbl_GhiChu;
    private javax.swing.JLabel lbl_MaKhachHang;
    private javax.swing.JLabel lbl_MaLuotThue;
    private javax.swing.JLabel lbl_NgayGioThue;
    private javax.swing.JLabel lbl_TongTien;
    private javax.swing.JTable tbl_LuotThue;
    private javax.swing.JTextField txt_Coc;
    private javax.swing.JTextField txt_GhiChu;
    private javax.swing.JTextField txt_MaKhachHang;
    private javax.swing.JTextField txt_MaLuotThue;
    private javax.swing.JTextField txt_NgayGioThue;
    private javax.swing.JTextField txt_TongTien;
    // End of variables declaration//GEN-END:variables
}
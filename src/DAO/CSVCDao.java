/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import model.CSVC;
import model.DatabaseConnect;

/**
 *
 * @author DucHieu
 */
public class CSVCDao {
    private static DatabaseConnect db = new DatabaseConnect();
    private static java.sql.Connection conn = db.Connect();
    
    public List<CSVC> layDanhSachCSVC() throws  SQLException{
        List<CSVC> danhSachCSVC = new ArrayList<CSVC>();
        java.sql.Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CSVC");
        while(resultSet.next()){
            String maCSVC = resultSet.getString("MaCSVC");
            String tenVatTu = resultSet.getString("TenVatTu");
            double giaCSVC = Double.parseDouble(resultSet.getString("Gia"));
            String ghiChuCSVC = resultSet.getString("GhiChu");
            CSVC csvc = new CSVC(maCSVC,tenVatTu,giaCSVC,ghiChuCSVC);
            danhSachCSVC.add(csvc);
        }
        return danhSachCSVC;
    }

    public void themCSVC(String MaCSVC, String TenVatTu, double GiaCSVC, String GhiChuCSVC) throws SQLException{
        PreparedStatement prepardStatement = conn.prepareStatement("INSERT INTO CSVC(MaCSVC, TenVatTu, Gia, GhiChu) VALUES(?,?,?,?)");
        prepardStatement.setString(1,MaCSVC);
        prepardStatement.setString(2,TenVatTu);
        prepardStatement.setDouble(3,GiaCSVC);
        prepardStatement.setString(4,GhiChuCSVC);
        prepardStatement.executeUpdate();
    }
public CSVC timCSVCTheoMa(String MaCSVC) throws SQLException{
        String tenVatTu;
        Double giaCSVC;
        String ghiChuCSVC;
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM CSVC WHERE MaCSVC =?");
        preparedStatement.setString(1,MaCSVC);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            tenVatTu = resultSet.getString("TenVatTu");
            giaCSVC = Double.valueOf(resultSet.getString("Gia"));
            ghiChuCSVC = resultSet.getString("GhiChu");
            CSVC csvc = new CSVC(MaCSVC,tenVatTu,giaCSVC,ghiChuCSVC);
            return csvc;
        }else{
            return null;
        }
    }
    
    public void xoaCSVC(String macsvc) throws SQLException{
        PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM CSVC WHERE MaCSVC=?");
        preparedStatement.setString(1, macsvc);
        preparedStatement.executeUpdate();
    }
    
    public void suaCSVC(String MaCSVC, String TenVatTu, double GiaCSVC, String GhiChuCSVC) throws SQLException{
        //Hàm sửa CSVC
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM CSVC WHERE MaCSVC=?");
        preparedStatement.setString(1, MaCSVC);
        ResultSet rs = preparedStatement.executeQuery();
            
        if(TenVatTu.equals("")){
            //Chỉ sửa GiaCSVC
            if(rs.next()){
                preparedStatement = conn.prepareStatement("UPDATE CSVC SET Gia = ? WHERE MaCSVC = ?");
                preparedStatement.setDouble(1,GiaCSVC);
                preparedStatement.setString(2,MaCSVC);
//                preparedStatement.setString(3, GhiChuCSVC);
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Sửa thành công giá CSVC " + MaCSVC, "Thành Công", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Không sửa thành công", "Lỗi", 0);
            }
        }else if(GiaCSVC==0){
            //Chỉ sửa TenVatTu
            if(rs.next()){
                preparedStatement = conn.prepareStatement("UPDATE CSVC SET TenVatTu = ? WHERE MaCSVC = ?");
                preparedStatement.setString(1, TenVatTu);
                preparedStatement.setString(2,MaCSVC);
//                preparedStatement.setString(3, GhiChuCSVC);
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Sửa thành công tên vật tư " + MaCSVC, "Thành Công", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Không sửa thành công", "Lỗi", 0);
            }
        }else{
            //Sửa GiaCSVC và TenVatTu
            if(rs.next()){
                preparedStatement = conn.prepareStatement("UPDATE CSVC SET TenVatTu = ?, Gia = ? WHERE MaCSVC = ?");
                preparedStatement.setString(1,TenVatTu);
                preparedStatement.setDouble(2,GiaCSVC);
                preparedStatement.setString(3,MaCSVC);
//                preparedStatement.setString(4, GhiChuCSVC);
                preparedStatement.execute();
                JOptionPane.showMessageDialog(null, "Sửa thành công thông tin CSVC " + MaCSVC, "Thành Công", 1);
            }else{
                JOptionPane.showMessageDialog(null, "Không sửa thành công", "Lỗi", 0);
            }
        }
            
    }
}

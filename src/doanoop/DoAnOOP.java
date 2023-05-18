/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package doanoop;
import view.*;
import model.*;
import controller.*;
/**
 *
 * @author huylequang
 */
public class DoAnOOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame_Login FormLogin = new JFrame_Login();
        NhanVienDao NhanVien = new NhanVienDao();
        LoginController LoginControl = new LoginController(FormLogin,NhanVien);
        MainForm main = LoginControl.getFrm_main();
        KhachHangDao khdao = new KhachHangDao();
        KhachHangFormController khctrl = new KhachHangFormController(main,khdao);
    }
    
}

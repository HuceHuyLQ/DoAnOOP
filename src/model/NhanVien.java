/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Optional;
/**
 *
 * @author huylequang
 */
public class NhanVien {
    private String MaNhanVien;
    private String TenNhanVien;
    private String SdtNV;
    private String Email;
    private String TenTK;
    private String MatKhau;
    private String VaiTro;

    public NhanVien() {
    }

    
    
    public NhanVien(String MaNhanVien, String TenNhanVien, String SdtNV, String Email, String TenTK, String MatKhau, String VaiTro) {
        this.MaNhanVien = MaNhanVien;
        this.TenNhanVien = TenNhanVien;
        this.SdtNV = SdtNV;
        this.Email = Email;
        this.TenTK = TenTK;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }

    
    
    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String TenNhanVien) {
        this.TenNhanVien = TenNhanVien;
    }

    public String getSdtNV() {
        return SdtNV;
    }

    public void setSdtNV(String SdtNV) {
        this.SdtNV = SdtNV;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTenTK() {
        return TenTK;
    }

    public void setTenTK(String TenTK) {
        this.TenTK = TenTK;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    
}

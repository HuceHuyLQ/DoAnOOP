/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nguyenhuuhieu
 */
public class LuotThue {
    private String MaLuotThue;
    private String MaKhachHang;
    private String MaPhong;
    private String MaNhanVien;
    private String NgayGioThue;
    private double Coc;
    private double TongTien;
    private String GhiChu;

    public LuotThue() {
    }

    public LuotThue(String MaLuotThue, String MaKhachHang, String MaPhong, String MaNhanVien, String NgayGioThue, double Coc, double TongTien, String GhiChu) {
        this.MaLuotThue = MaLuotThue;
        this.MaKhachHang = MaKhachHang;
        this.MaPhong = MaPhong;
        this.MaNhanVien = MaNhanVien;
        this.NgayGioThue = NgayGioThue;
        this.Coc = Coc;
        this.TongTien = TongTien;
        this.GhiChu = GhiChu;
    }

    public String getMaLuotThue() {
        return MaLuotThue;
    }

    public void setMaLuotThue(String MaLuotThue) {
        this.MaLuotThue = MaLuotThue;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getNgayGioThue() {
        return NgayGioThue;
    }

    public void setNgayGioThue(String NgayGioThue) {
        this.NgayGioThue = NgayGioThue;
    }

    public double getCoc() {
        return Coc;
    }

    public void setCoc(double Coc) {
        this.Coc = Coc;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    

}

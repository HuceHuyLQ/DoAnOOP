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
    private String NgayThue;
    private String GioBatDau;
    private String GioKetThuc;
    private double Coc;
    private double TongTien;
    private String GhiChu;

    public LuotThue() {
    }

    public LuotThue(String MaLuotThue, String MaKhachHang, String MaPhong, String MaNhanVien, String NgayThue, String GioBatDau, String GioKetThuc, double Coc, double TongTien, String GhiChu) {
        this.MaLuotThue = MaLuotThue;
        this.MaKhachHang = MaKhachHang;
        this.MaPhong = MaPhong;
        this.MaNhanVien = MaNhanVien;
        this.NgayThue = NgayThue;
        this.GioBatDau = GioBatDau;
        this.GioKetThuc = GioKetThuc;
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

    public String getNgayThue() {
        return NgayThue;
    }

    public void setNgayThue(String NgayThue) {
        this.NgayThue = NgayThue;
    }

    public String getGioBatDau() {
        return GioBatDau;
    }

    public void setGioBatDau(String GioBatDau) {
        this.GioBatDau = GioBatDau;
    }

    public String getGioKetThuc() {
        return GioKetThuc;
    }

    public void setGioKetThuc(String GioKetThuc) {
        this.GioKetThuc = GioKetThuc;
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

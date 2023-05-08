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
    private int MaNV;
    private String HoTenNV;
    private String SDTNV;
    private String MatKhauNV;

    public NhanVien(int MaNV, String HoTenNV, String SDTNV, String MatKhauNV) {
        this.MaNV = MaNV;
        this.HoTenNV = HoTenNV;
        this.SDTNV = SDTNV;
        this.MatKhauNV = MatKhauNV;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTenNV() {
        return HoTenNV;
    }

    public void setHoTenNV(String HoTenNV) {
        this.HoTenNV = HoTenNV;
    }

    public String getSDTNV() {
        return SDTNV;
    }

    public void setSDTNV(String SDTNV) {
        this.SDTNV = SDTNV;
    }

    public String getMatKhauNV() {
        return MatKhauNV;
    }

    public void setMatKhauNV(String MatKhauNV) {
        this.MatKhauNV = MatKhauNV;
    }
    
}

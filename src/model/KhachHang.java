/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huylequang
 */
public class KhachHang {
    private String MaKH;
    private String HoTenKH;
    private String SDTKH;

    public KhachHang(String MaKH, String HoTenKH, String SDTKH) {
        this.MaKH = MaKH;
        this.HoTenKH = HoTenKH;
        this.SDTKH = SDTKH;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getHoTenKH() {
        return HoTenKH;
    }

    public void setHoTenKH(String HoTenKH) {
        this.HoTenKH = HoTenKH;
    }

    public String getSDTKH() {
        return SDTKH;
    }

    public void setSDTKH(String SDTKH) {
        this.SDTKH = SDTKH;
    }
    
    
}

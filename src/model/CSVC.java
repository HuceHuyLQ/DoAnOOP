/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DucHieu
 */
public class CSVC {
    private String MaCSVC;
    private String TenVatTu;
    private Double GiaCSVC;
    private String GhiChuCSVC;
    
    public CSVC(String MaCSVC, String TenVatTu, Double GiaCSVC, String GhiChuCSVC){
        this.MaCSVC = MaCSVC;
        this.TenVatTu = TenVatTu;
        this.GiaCSVC = GiaCSVC;
        this.GhiChuCSVC = GhiChuCSVC;
    }

    public String getMaCSVC() {
        return MaCSVC;
    }

    public void setMaCSVC(String MaCSVC) {
        this.MaCSVC = MaCSVC;
    }

    public String getTenVatTu() {
        return TenVatTu;
    }

    public void setTenVatTu(String TenVatTu) {
        this.TenVatTu = TenVatTu;
    }

    public Double getGiaCSVC() {
        return GiaCSVC;
    }

    public void setGiaCSVC(Double GiaCSVC) {
        this.GiaCSVC = GiaCSVC;
    }

    public String getGhiChuCSVC() {
        return GhiChuCSVC;
    }

    public void setGhiChuCSVC(String GhiChuCSVC) {
        this.GhiChuCSVC = GhiChuCSVC;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 03qua
 */
public class Phong {
    private String MaPhong;
    private String LoaiPhong;
    private float GiaThue;

    public Phong(String MaPhong, String LoaiPhong, float GiaThue) {
        this.MaPhong = MaPhong;
        this.LoaiPhong = LoaiPhong;
        this.GiaThue = GiaThue;
    }

    public Phong() {
        
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public float getGiaThue() {
        return GiaThue;
    }

    public void setGiaThue(float GiaThue) {
        this.GiaThue = GiaThue;
    }

}

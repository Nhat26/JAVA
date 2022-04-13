/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hiep4
 */
public class LoaiHang {
    private String maLH, tenLH;
    int giaThanhPham;

    public LoaiHang() {
    }

    public LoaiHang(String loaiHang) {
        this.maLH = maLH;
    }

    public LoaiHang(String maLH, String tenLH, int giaThanhPham) {
        this.maLH = maLH;
        this.tenLH = tenLH;
        this.giaThanhPham = giaThanhPham;
    }
    
    

    public String getMaLH() {
        return maLH;
    }

    public void setMaLH(String maLH) {
        this.maLH = maLH;
    }

    public String getTenLH() {
        return tenLH;
    }
    
    public void setTenLH(String tenLH) {
        this.tenLH = tenLH;
    }

    public int getGiaThanhPham() {
        return giaThanhPham;
    }
        public void setGiaThanhPham(int giaThanhPham) {
        this.giaThanhPham = giaThanhPham;
    }



    @Override
    public String toString() {
        return "LoaHang{" + "maLH ="  + maLH + ", tenLH=" + tenLH + ", giaThanhPham=" + giaThanhPham + '}';
    }
    
}

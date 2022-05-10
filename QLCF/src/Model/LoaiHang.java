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
    private String tenLH;
    private int giaThanhPham , maLH;
    
    public LoaiHang() {
    }  
    public LoaiHang(int maLH, String tenLH, int giaThanhPham ) {
        this.maLH = maLH;
        this.tenLH = tenLH;
        this.giaThanhPham = giaThanhPham;
    }
    
    public LoaiHang(int maLH, String tenLH) {
        this.maLH = maLH;
        this.tenLH = tenLH;
    }

    public int getMaLH() {
        return maLH;
    }

    public void setMaLH(int maLH) {
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
        return tenLH.toString();
    }



    
}

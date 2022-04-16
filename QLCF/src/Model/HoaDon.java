/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nhat
 */
public class HoaDon {
    private String maHD,maBan,maNV,ngayLapHD;
    int tongTien, khuyenMai;
    public HoaDon() {
    }

    public HoaDon(String HoaDon) {
        this.maHD = maHD;
    }

    public HoaDon(String maHD, String maBan, String maNV,String ngayLapHD, int tongTien, int khuyenMai) {
        this.maHD = maHD;
        this.maBan = maBan;
        this.maNV = maNV;
        this.ngayLapHD = ngayLapHD;
        this.tongTien = tongTien;
        this.khuyenMai = khuyenMai;
    }

    public String getMaHD() {
        return maHD;
    }

    public String getMaBan() {
        return maBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getNgayLapHD() {
        return ngayLapHD;
    }

    public int getTongTien() {
        return tongTien;
    }

    public int getKhuyenMai() {
        return khuyenMai;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setNgayLapHD(String ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public void setKhuyenMai(int khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
    
    @Override
     public String toString() {
        return "HoaDon{" + "maHD ="  + maHD + ", maBan=" + maBan + ",ngayLapHD="+ngayLapHD+",tongTien="+ tongTien +", khuyenMai=" + khuyenMai + '}';
    }
}

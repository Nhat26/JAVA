/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Timestamp;

/**
 *
 * @author nhat
 */
public class HoaDon {
    private String tinhTrang;
    private int tongTien, khuyenMai, maHD, maBan,maNV;
    private  Timestamp ngayLapHD;
    
    public HoaDon() {
    }

    public HoaDon(int maHD, int maBan, int maNV, Timestamp ngayLapHD, int tongTien, int khuyenMai, String tinhTrang) {
        this.maHD = maHD;
        this.maBan = maBan;
        this.maNV = maNV;
        this.ngayLapHD = ngayLapHD;
        this.tongTien = tongTien;
        this.khuyenMai = khuyenMai;
        this.tinhTrang = tinhTrang;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public Timestamp getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(Timestamp ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    public int getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(int khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", maBan=" + maBan + ", maNV=" + maNV + ", ngayLapHD=" + ngayLapHD + ", tongTien=" + tongTien + ", khuyenMai=" + khuyenMai + ", tinhTrang=" + tinhTrang + '}';
    }

    

}

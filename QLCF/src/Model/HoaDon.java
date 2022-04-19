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
    boolean tinhTrang;
    
    public HoaDon() {
    }

    public HoaDon(String maHD, String maBan, String maNV, String ngayLapHD, int tongTien, int khuyenMai, boolean tinhTrang) {
        this.maHD = maHD;
        this.maBan = maBan;
        this.maNV = maNV;
        this.ngayLapHD = ngayLapHD;
        this.tongTien = tongTien;
        this.khuyenMai = khuyenMai;
        this.tinhTrang = tinhTrang;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(String ngayLapHD) {
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

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHD=" + maHD + ", maBan=" + maBan + ", maNV=" + maNV + ", ngayLapHD=" + ngayLapHD + ", tongTien=" + tongTien + ", khuyenMai=" + khuyenMai + ", tinhTrang=" + tinhTrang + '}';
    }

    

}

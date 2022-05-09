/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author THE LUC
 */
public class CTHoaDon {
    private int maHD, maLH,soLuong;

    public CTHoaDon() {
    }

    public CTHoaDon(int maHD, int maLH, int soLuong) {
        this.maHD = maHD;
        this.maLH = maLH;
        this.soLuong = soLuong;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaLH() {
        return maLH;
    }

    public void setMaLH(int maLH) {
        this.maLH = maLH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "CTHoaDon{" + "maHD=" + maHD + ", maLH=" + maLH + ", soLuong=" + soLuong + '}';
    }
    
    
    
}

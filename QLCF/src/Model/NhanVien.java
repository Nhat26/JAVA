/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hiep4
 */
public class NhanVien {
    private String maNV,tenNV,chucVu,ngayVaoLam;
    int sDT;
    boolean gioiTinh;
    
    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV, int sDT, String chucVu, String ngayVaoLam, boolean gioiTinh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.sDT = sDT;
        this.chucVu = chucVu;
        this.ngayVaoLam = ngayVaoLam;
        this.gioiTinh = gioiTinh;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    
    public int getSDT()
    {
        return sDT;
    }
    
    public void setSDT(int sDT){
        this.sDT = sDT;
    }
    
    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
    
    public String getNgayVaoLam(){
        return ngayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", sDT=" + sDT + ", chucVu=" + chucVu + ", gioiTinh=" + gioiTinh + ", ngayVaoLam=" + ngayVaoLam + '}';
    }
}

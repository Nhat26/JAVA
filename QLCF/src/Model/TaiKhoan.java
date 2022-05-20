/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hiep4
 */
public class TaiKhoan {
    private String taiKhoan, matKhau, loaiTK, tenNV;
    int maTK,maNV;

    public TaiKhoan() {
    }

    public TaiKhoan(int maTK,String taiKhoan, String matKhau, String loaiTK, int maNV, String tenNV) {
        this.maTK = maTK;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.loaiTK = loaiTK;
        this.maNV = maNV;
        this.tenNV = tenNV;
    }
    
    public TaiKhoan(int maTK) {
        this.maTK = maTK;
    }
    
    public int getMaTK() {
        return maTK;
    }
    
     public void setMaTK(int maTK) {
         this.maTK = maTK;
    }
    
    public TaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
    
    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getLoaiTK() {
        return loaiTK;
    }

    public void setLoaiTK(String loaiTK) {
        this.loaiTK = loaiTK;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "taiKhoan=" + taiKhoan + ", matKhau=" + matKhau + ", loaiTK=" + loaiTK + ", tenNV=" + tenNV + ", maTK=" + maTK + ", maNV=" + maNV + '}';
    }
    
    

    
    
    
    
}

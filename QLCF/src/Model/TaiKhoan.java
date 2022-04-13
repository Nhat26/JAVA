/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author THE LUC
 */
public class TaiKhoan {
    private String taiKhoan, matKhau, loaiTK, maNV;

    public TaiKhoan() {
    }

    public TaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public TaiKhoan(String taiKhoan, String matKhau, String loaiTK, String maNV) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.loaiTK = loaiTK;
        this.maNV = maNV;
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

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" + "taiKhoan ="  + taiKhoan + ", matKhau=" + matKhau + ", loaiTK=" + loaiTK + ", maNV=" + maNV + '}';
    }
    
    
    
    
}

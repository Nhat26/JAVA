/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author hiep4
 */
public class Ban {
    private String soBan;
    private int maBan;
    private boolean tinhTrang;

    public Ban() {
    }

    public Ban(String ban) {
        this.maBan = maBan;
    }

    public Ban(int maBan, String soBan, boolean tinhTrang) {
        this.maBan = maBan;
        this.soBan = soBan;
        this.tinhTrang = tinhTrang;
    }
    
    

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public String getSoBan() {
        return soBan;
    }

    public void setSoBan(String soBan) {
        this.soBan = soBan;
    }

    public boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }


    @Override
    public String toString() {
        return "Ban{" + "maBan ="  + maBan + ", soBan=" + soBan + ", tinhTrang=" + tinhTrang + '}';
    }
}

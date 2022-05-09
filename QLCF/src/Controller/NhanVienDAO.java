/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.NhanVien;
import Helper.DatabaseHelper;
import Model.Ban;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiep4
 */
public class NhanVienDAO {
    private static NhanVienDAO instance;
    NhanVien nhanVien = new NhanVien();
    
     public static NhanVienDAO getInstance() {
        if (instance == null) {
            instance = new NhanVienDAO();
        }
        return instance;
    }
     public static void setInstance(NhanVienDAO instance) {
        NhanVienDAO.instance = instance;
    }
    
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    
    public List<NhanVien> listNhanVien()
    {
        List<NhanVien> list = new ArrayList<>();
        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM NhanVien";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                   NhanVien nhanVien = new NhanVien();
                   nhanVien.setMaNV(rs.getInt(1));
                   nhanVien.setTenNV(rs.getString(2));
                   nhanVien.setGioiTinh(rs.getBoolean(3));
                   nhanVien.setSDT(rs.getInt(4));
                   nhanVien.setChucVu(rs.getString(5));
                   nhanVien.setNgayVaoLam(rs.getString(6));
                   list.add(nhanVien);               
            }
        } catch (Exception e) {
            System.out.println("Loi "+ e.toString());
        }
        finally{
            try {
                rs.close();
                statement.close();
                conn.close();   
            } catch (Exception e) {
            }
        }
        return list;
}
    
    public NhanVien GetNhanVien() {
        return nhanVien;
    }
    public Boolean Add(NhanVien nhanVien) throws SQLException {
        String sql = "INSERT INTO NhanVien(MaNV, TenNV, GioiTinh, SDT, ChucVu, NgayVaoLam) VALUES (?,?,?,?,?,?)";

        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  PreparedStatement stsm = conn.prepareStatement(sql);) {
            stsm.setInt(1, nhanVien.getMaNV());
            stsm.setString(2, nhanVien.getTenNV());
            stsm.setBoolean(3, nhanVien.getGioiTinh());
            stsm.setInt(4, nhanVien.getSDT());
            stsm.setString(5, nhanVien.getChucVu());
            stsm.setString(6, nhanVien.getNgayVaoLam());
            

            return stsm.executeUpdate() > 0;
        }
    }
     
      public Boolean Update(NhanVien nhanVien) throws SQLException{
        String sql = "UPDATE nhanVien SET tenNV = ?, gioitinh = ?, SDT = ?, chucvu = ?, ngayvaolam = ? " + "WHERE maNV = ?";
        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  
                PreparedStatement stsm = conn.prepareStatement(sql);
                ) 
        {
            
            stsm.setString(1, nhanVien.getTenNV());
            stsm.setBoolean(2, nhanVien.getGioiTinh());
            stsm.setInt(3, nhanVien.getSDT());
            stsm.setString(4, nhanVien.getChucVu());
            stsm.setString(5, nhanVien.getNgayVaoLam());
            stsm.setInt(6, nhanVien.getMaNV());
            
            return stsm.executeUpdate() > 0;
        }
    }
    public Boolean Delete(String MaNV) throws SQLException {
        String sql = "delete from NhanVien where MaNV =? ";
        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  
                PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, MaNV);
            return pstm.executeUpdate() > 0;
        }
    }
    public List<NhanVien> timListNhanVien(String nhanVien) {
        List<NhanVien> list = new ArrayList<>();
        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM NHANVIEN WHERE TenNV like '%" + nhanVien + "%'";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                 NhanVien nv = new NhanVien();
                 nv.setMaNV(rs.getInt(1));
                 nv.setTenNV(rs.getString(2));
                 nv.setGioiTinh(rs.getBoolean(3));
                 nv.setSDT(rs.getInt(4));
                 nv.setChucVu(rs.getString(5));
                 nv.setNgayVaoLam(rs.getString(6));
                 list.add(nv); 
                return list;
            }
        } catch (Exception e) {
            System.out.println("Loi khong tim thay nhan vien " + e.toString());
        } finally {
            try {
                rs.close();
                statement.close();
                conn.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.HoaDon;
import Model.NhanVien;
import View.frmQuanLyBan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;
/**
 *
 * @author nhat
 */
public class HoaDonDAO {
    private static HoaDonDAO instance;
    HoaDon hoaDon = new HoaDon();
    public HoaDonDAO() {
    }
    
    public static HoaDonDAO getInstance() {
        if (instance == null) {
            instance = new HoaDonDAO();
        }
        return instance;
    }
    
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    public List<HoaDon> listHoaDon()
    {
        List<HoaDon> list = new ArrayList<>();
        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM HoaDon";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                   HoaDon HD = new HoaDon();
                   HD.setMaHD(rs.getInt(1));
                   HD.setMaBan(rs.getInt(2));
                   HD.setMaNV(rs.getInt(3));
                   HD.setTongTien(rs.getInt(4));
                   HD.setNgayLapHD(rs.getTimestamp(5));
                   HD.setKhuyenMai(rs.getInt(6));
                   list.add(HD);               
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
    
     public HoaDon GetNhanVien() {
        return hoaDon;
    }
    
    public int GetUncheckInvoiceByTableId(int maHD) {
        Connection con = Helper.DatabaseHelper.getDBConnect();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM HoaDon WHERE MaBan = ? AND TinhTrang = 0");
            pstmt.setInt(1, maHD);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
//                Invoices invoices = new Invoices(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public Boolean Insert(int MaBan, int MaNV) {
        Connection con = Helper.DatabaseHelper.getDBConnect();
        try {
            Statement stmt = con.createStatement();
            int i = stmt.executeUpdate("INSERT INTO HoaDon(MaBan, MaNV, NgayLapHD ,TinhTrang) VALUES ('" + MaBan + "','" + MaNV + "',GETDATE(),0)");
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(frmQuanLyBan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
      
    
    
    public HoaDon get1HD(String maHD){
         ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM TAIKHOAN WHERE TAIKHOAN ='" + maHD + "'";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                HoaDon tk = new HoaDon();
                tk.setMaHD(rs.getInt(1));
                tk.setNgayLapHD(rs.getTimestamp(2));
                tk.setTongTien(rs.getInt(3));
                tk.setMaNV(rs.getInt(4));
                tk.setMaBan(rs.getInt(5));
                tk.setKhuyenMai(rs.getInt(6));
                return tk;
            }
        } catch (Exception e) {
            System.out.println("Loi khong tim thay hoa don " + e.toString());
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
    public int GetMaxIdInvoice() {
        Connection con = Helper.DatabaseHelper.getDBConnect();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT MAX(MaHD) FROM HoaDon");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 1;
    }
    public void Update(int id, int totalPrice) {
        Connection con = Helper.DatabaseHelper.getDBConnect();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE HoaDon SET TinhTrang= 1, TongTien = ? WHERE MaHD = ?");
            pstmt.setInt(1, totalPrice);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
//                int i = pstmt.executeUpdate();
//                if (i > 0) {
//                }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

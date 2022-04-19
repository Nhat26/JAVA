/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.HoaDon;
import View.frmQuanLyBan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author nhat
 */
public class HoaDonDAO {
    private static HoaDonDAO instance;
    
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
            String sql = "SELECT * FROM MaHD";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                   HoaDon HD = new HoaDon();
                   HD.setMaHD(rs.getString(1));
                   HD.setMaBan(rs.getString(2));
                   HD.setMaNV(rs.getString(3));
                   HD.setTongTien(rs.getInt(4));
                   HD.setNgayLapHD(rs.getString(5));
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
    
    public int GetUncheckInvoiceByTableId(int id) {
        Connection con = Helper.DatabaseHelper.getDBConnect();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM HoaDon WHERE MaBan = ? AND TinhTrang = 0");
            pstmt.setInt(1, id);
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
    
    public Boolean Insert(int id, int MaNV) {
        Connection con = Helper.DatabaseHelper.getDBConnect();
        try {
            Statement stmt = con.createStatement();
            int i = stmt.executeUpdate("INSERT INTO HoaDon(MaNV, MaBan, TinhTrang) VALUES ('" + MaNV + "','" + id + "',0)");
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
                tk.setMaHD(rs.getString(1));
                tk.setNgayLapHD(rs.getString(2));
                tk.setTongTien(rs.getInt(3));
                tk.setMaNV(rs.getString(4));
                tk.setMaBan(rs.getString(5));
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
    
}

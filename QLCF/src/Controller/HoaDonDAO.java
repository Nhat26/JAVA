/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.HoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.HoaDon;
import Helper.DatabaseHelper;
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
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.LoaiHang;
import Helper.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiep4
 */
public class LoaiHangDAO {
    private static LoaiHangDAO instance;
    LoaiHang loaiHang = new LoaiHang();
    public LoaiHangDAO() {
    }
    
    public static LoaiHangDAO getInstance() {
        if (instance == null) {
            instance = new LoaiHangDAO();
        }
        return instance;
    }
    
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    public List<LoaiHang> listLoaiHang()
    {
        List<LoaiHang> list = new ArrayList<>();
        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM LoaiHang";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                   LoaiHang ban = new LoaiHang();
                   ban.setMaLH(rs.getInt(1));
                   ban.setTenLH(rs.getString(2));
                   ban.setGiaThanhPham(rs.getInt(3));
                   list.add(ban);               
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
    
     public LoaiHang GetLoaiHang() {
        return loaiHang;
    }
    
    public ArrayList<String> listTenLoaiHang()
    {
        ArrayList<String> list = new ArrayList<String>();
        ResultSet rs = null;
        Statement statement = null;
        try { 
            String sql = "SELECT tenLH FROM LoaiHang";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            
            while (rs.next()) {                  
                   list.add(rs.getString("tenLH"));               
            }
        } catch (Exception e) {
            System.out.println("Loi "+ e.toString());
        }
        return list;
}
    
    
    
    public Boolean Add(LoaiHang LH) throws SQLException {
//        Connection con = Helper.DatabaseHelper.getDBConnect();
        String sql = "INSERT INTO LOAIHANG(MaLH, tenLH, GiaThanhPham) VALUES (?,?,?)";

        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  
                PreparedStatement stsm = conn.prepareStatement(sql);) {
            stsm.setInt(1, LH.getMaLH());
            stsm.setString(2, LH.getTenLH());
            
            stsm.setInt(3, LH.getGiaThanhPham());
            

            return stsm.executeUpdate() > 0;
        }
    }
    
     public Boolean Update(LoaiHang LH) throws SQLException{
        String sql = "UPDATE loaihang SET tenLH = ?, giathanhpham = ? " + "WHERE malh = ?";
        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  
                PreparedStatement stsm = conn.prepareStatement(sql);
                ) 
        {
            stsm.setInt(3, LH.getMaLH());
            stsm.setString(1, LH.getTenLH());
            stsm.setInt(2, LH.getGiaThanhPham());

            
            return stsm.executeUpdate() > 0;
        }
    }
      public Boolean Delete(String MaLH) throws SQLException {
        String sql = "delete from LoaiHang where MaLH =? ";
        try (
                Connection conn = Helper.DatabaseHelper.getDBConnect();  
                PreparedStatement pstm = conn.prepareStatement(sql);
            ) 
        {
                pstm.setString(1, MaLH);
                return pstm.executeUpdate() > 0;
        }
      }
      
      public List<LoaiHang> getAllclasses()
            {
                ResultSet rs = null;
                Statement statement = null;
                try{
                    String sql = "SELECT * FROM LoaiHang ";
                    conn = Helper.DatabaseHelper.getDBConnect();
                    statement = conn.createStatement();
                    rs = statement.executeQuery(sql);
                    List<LoaiHang> list = new ArrayList<>();
                    while(rs.next())
                        {
                            list.add(new LoaiHang(rs.getInt("maLH"), rs.getString("tenLH")));
                            
                        }
                    return list;
                }catch(Exception e)
                    {
                        System.out.println("Loi khong tim thay loai hang " + e.toString());
                    }
                return null;
            }
}

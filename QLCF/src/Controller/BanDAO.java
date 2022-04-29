/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Ban;
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
public class BanDAO {
     private static BanDAO instance;
    Ban ban = new Ban();
    
     public static BanDAO getInstance() {
        if (instance == null) {
            instance = new BanDAO();
        }
        return instance;
    }
     public static void setInstance(BanDAO instance) {
        BanDAO.instance = instance;
    }
    
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    
    public List<Ban> listBan()
    {
        List<Ban> list = new ArrayList<>();
        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM Ban";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                   Ban ban = new Ban();
                   ban.setMaBan(rs.getString(1));
                   ban.setSoBan(rs.getString(2));
                   ban.setTinhTrang(rs.getString(3));
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
     public Boolean Add(Ban ban) throws SQLException {
//        Connection con = Helper.DatabaseHelper.getDBConnect();
        String sql = "INSERT INTO Ban(MaBan, SoBan, TinhTrang) VALUES (?,?,?)";

        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  PreparedStatement stsm = conn.prepareStatement(sql);) {
            stsm.setString(1, ban.getMaBan());
            stsm.setString(2, ban.getSoBan());
            stsm.setString(3, ban.getTinhTrang());
            

            return stsm.executeUpdate() > 0;
        }
    }
     
      public Boolean Update(Ban ban) throws SQLException{
        String sql = "UPDATE ban SET soban = ?, tinhtrang = ? " + "WHERE maban = ?";
        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  
                PreparedStatement stsm = conn.prepareStatement(sql);
                ) 
        {
            stsm.setString(3, ban.getMaBan());
            stsm.setString(1, ban.getSoBan());
            stsm.setString(2, ban.getTinhTrang());

            
            return stsm.executeUpdate() > 0;
        }
    }
    public Boolean Delete(String MaBan) throws SQLException {
        String sql = "delete from BAN where MaBan =? ";
        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, MaBan);
            return pstm.executeUpdate() > 0;
        }
    }
}

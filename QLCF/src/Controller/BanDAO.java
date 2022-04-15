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
    Ban taikhoan = new Ban();
    
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
    public Boolean Delete(String SoBan) throws SQLException {
        String sql = "delete from BAN where SoBan =? ";
        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, SoBan);
            return pstm.executeUpdate() > 0;
        }
    }
}

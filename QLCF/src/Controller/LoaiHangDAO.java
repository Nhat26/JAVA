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
                   ban.setMaLH(rs.getString(1));
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
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.frmQuanLyThucDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controller.CTHoaDonDAO;
import Controller.HoaDonDAO;
import Model.CTHoaDon;
/**
 *
 * @author THE LUC
 */
public class CTHoaDonDAO {
    private static CTHoaDonDAO instance;
    
    public static CTHoaDonDAO getInstance() {
        if (instance == null) {
            instance = new CTHoaDonDAO();
        }
        return instance;
    }
    
    public List<CTHoaDon> ListOrder(String id) {
        List<CTHoaDon> list = new ArrayList<CTHoaDon>();
        Connection con = Helper.DatabaseHelper.getDBConnect();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM `cthoadon` WHERE `MAHD` = ?");
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                CTHoaDon orders = new CTHoaDon(rs.getString(1), rs.getString(2), rs.getInt(3));
                list.add(orders);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public Boolean Insert(String drinkId, int invoiceId, int count) {
        Connection con = Helper.DatabaseHelper.getDBConnect();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO CTHOADON(MaHD, MaLH,SOLUONG ) VALUES (?,?,?)");
            pstmt.setInt(1, invoiceId);
            pstmt.setString(2, drinkId);
            pstmt.setInt(3, count);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
           Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void updateStatus(String idTable) {
        Connection con = Helper.DatabaseHelper.getDBConnect();
        
            try {
                    PreparedStatement pstmt;
                    pstmt = con.prepareStatement("update Ban set TinhTrang=1 where MaBan=? ");
                    pstmt.setString(1,idTable );
                    pstmt.executeUpdate();
                    
            } catch (SQLException ex) {
                    Logger.getLogger(frmQuanLyThucDon.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void Insert(String maLH, String MaHD, int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    
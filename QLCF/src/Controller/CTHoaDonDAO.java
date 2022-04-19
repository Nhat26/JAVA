/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Helper.DatabaseHelper;
import Model.CTHoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public Boolean Insert(int drinkId, int invoiceId, int count) {
        Connection con = Helper.DatabaseHelper.getDBConnect();
        try {
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO CTHOADON(MaHD, MaLH,SOLUONG ) VALUES (?,?,?)");
            pstmt.setInt(1, invoiceId);
            pstmt.setInt(2, drinkId);
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
}
    

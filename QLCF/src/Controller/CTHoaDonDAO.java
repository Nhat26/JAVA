/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.frmQuanLyThucDon;
import java.sql.*;
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
}
    

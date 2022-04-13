/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.TaiKhoan;
import Helper.DatabaseHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author THE LUC
 */
public class TaiKhoanDAO {
    
     private static TaiKhoanDAO instance;
    TaiKhoan taikhoan = new TaiKhoan();
    
     public static TaiKhoanDAO getInstance() {
        if (instance == null) {
            instance = new TaiKhoanDAO();
        }
        return instance;
    }

    public static void setInstance(TaiKhoanDAO instance) {
        TaiKhoanDAO.instance = instance;
    }
    
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    
    public List<TaiKhoan> listTaiKhoan()
    {
        List<TaiKhoan> list = new ArrayList<>();
        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM TaiKhoan";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                   TaiKhoan tk = new TaiKhoan();
                   tk.setTaiKhoan(rs.getString(1));
                   tk.setMatKhau(rs.getString(2));
                   tk.setLoaiTK(rs.getString(3));
                   tk.setMaNV(rs.getString(4));
                   list.add(tk);               
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
    
    //
    
    public TaiKhoan get1TaiKhoan(){
        
        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM TaiKhoan";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                   TaiKhoan tk = new TaiKhoan();
                   tk.setTaiKhoan(rs.getString(1));
                   tk.setMatKhau(rs.getString(2));
                   tk.setLoaiTK(rs.getString(3));
                   tk.setMaNV(rs.getString(4));    
                   return tk;
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
        return null;
    }
    //
    public TaiKhoan timTaiKhoan(String taiKhoan){
        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM TAIKHOAN WHERE TAIKHOAN ='" +taiKhoan+"'";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {                
                TaiKhoan tk = new TaiKhoan();
                   tk.setTaiKhoan(rs.getString(1));
                   tk.setMatKhau(rs.getString(2));
                   tk.setLoaiTK(rs.getString(3));
                   tk.setMaNV(rs.getString(4));              
                   return tk;
            }            
        } catch (Exception e) {
            System.out.println("Loi khong tim thay tai khoan "+ e.toString());
        }
        finally{
            try {
                rs.close();
                statement.close();
                conn.close();   
            } catch (Exception e) {
            }
        }
        return null;

    }
    //
    public Boolean Login(String username, String password) 
    {
        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM TAIKHOAN WHERE TAIKHOAN ='" +username+"' and MATKHAU = '"+password+"' " ;
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            if (rs.next()) {
                taikhoan.setTaiKhoan(rs.getString(1));
                taikhoan.setMatKhau(rs.getString(2));
                taikhoan.setLoaiTK(rs.getString(3));
                taikhoan.setMaNV(rs.getString(4));
                
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
       public Boolean Add(String username, String pass, String loaiTK, String maNV) {
//        Connection con = Helper.DatabaseHelper.getDBConnect();
        ResultSet rs = null;
        Statement statement = null;
        try {
//            PreparedStatement pstmt = con.prepareStatement("INSERT INTO `taikhoan`(`taikhoan`, `password`, `loaiTK`, `maNV`) VALUES (?,?,?,?)");
//            pstmt.setString(1, username);
//            pstmt.setString(2, pass);
//            pstmt.setString(3, loaiTK);
//            pstmt.setString(4, maNV);
              String sql = "INSERT INTO `taikhoan`(`taikhoan`, `password`, `loaiTK`, `maNV`) VALUES (?,?,?,?)" ;
              conn = Helper.DatabaseHelper.getDBConnect();
              statement = conn.prepareStatement(sql);
              rs = statement.executeQuery(sql);
//            if (rs.next()) {
                taikhoan.setTaiKhoan(rs.getString(1));
                taikhoan.setMatKhau(rs.getString(2));
                taikhoan.setLoaiTK(rs.getString(3));
                taikhoan.setMaNV(rs.getString(4));
                return true;
//            }
//            int i = pstmt.executeUpdate();
//            if (i > 0)
//            {
//                return true;
//            }
            }
            catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean Update(String name, String pass, String loaiTK, String maNV) {
        Connection con = Helper.DatabaseHelper.getDBConnect();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE `account` SET `password`=?,`loaiTK`=?, `maNV=?` WHERE TaiKhoan=?");
            pstmt.setString(1, pass);
            pstmt.setString(3, loaiTK);
            pstmt.setString(4, maNV);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean Delete(String taikhoan) {
        Connection con = Helper.DatabaseHelper.getDBConnect();
        try {
            PreparedStatement pstmt = con.prepareStatement("Delete from account where TAIKHOAN=?");
            pstmt.setString(1, taikhoan);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean DoiMatKhau(String taikhoan, String pass) {
        Connection con = Helper.DatabaseHelper.getDBConnect();
        try {
            PreparedStatement pstmt = con.prepareStatement("UPDATE `account` SET `taikhoan`=?, `password`=? WHERE TaiKhoan=?");
            pstmt.setString(1, taikhoan);
            pstmt.setString(1, pass);
            int i = pstmt.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

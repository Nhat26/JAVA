/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.NhanVien;
import Model.TaiKhoan;
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

    public List<TaiKhoan> listTaiKhoan() {
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
                tk.setMaTK(rs.getInt(1));
                tk.setTaiKhoan(rs.getString(2));
                tk.setMatKhau(rs.getString(3));
                tk.setLoaiTK(rs.getString(4));
                tk.setTenNV(rs.getString(5));
                list.add(tk);
            }
        } catch (Exception e) {
            System.out.println("Loi " + e.toString());
        } finally {
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
    public TaiKhoan getTaiKhoan(){
        TaiKhoan taiKhoan = new TaiKhoan();
        return taiKhoan;
    }
    
    public TaiKhoan GetAccount() {
        return taikhoan;
    }
    //
    public TaiKhoan get1TaiKhoan(String taiKhoan) {

        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "Select TAIKHOAN.*, NHANVIEN.TENNV \n"
                    + "from TAIKHOAN \n"
                    + "join NHANVIEN on TAIKHOAN.MANV = NHANVIEN.MANV\n"
                    + "where TAIKHOAN.TaiKhoan = '"+taiKhoan+"'";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setMaTK(rs.getInt(1));
                tk.setTaiKhoan(rs.getString(2));
                tk.setMatKhau(rs.getString(3));
                tk.setLoaiTK(rs.getString(4));
                tk.setMaNV(rs.getInt(5));
                tk.setTenNV(rs.getString(6));
                return tk;
            }
        } catch (Exception e) {
            System.out.println("Loi " + e.toString());
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

    //
    public TaiKhoan timTaiKhoan(String taiKhoan) {
        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM TAIKHOAN WHERE TAIKHOAN ='" + taiKhoan + "'";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setMaTK(rs.getInt(1));
                tk.setTaiKhoan(rs.getString(2));
                tk.setMatKhau(rs.getString(3));
                tk.setLoaiTK(rs.getString(4));
                tk.setMaNV(rs.getInt(5));
                return tk;
            }
        } catch (Exception e) {
            System.out.println("Loi khong tim thay tai khoan " + e.toString());
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

    //
    public Boolean Login(String username, String password) {
        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM TAIKHOAN WHERE TAIKHOAN ='" + username + "' and MATKHAU = '" + password + "' ";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            if (rs.next()) {
                taikhoan.setTaiKhoan(rs.getString(1));
                taikhoan.setMatKhau(rs.getString(2));
                taikhoan.setLoaiTK(rs.getString(3));
                taikhoan.setMaNV(rs.getInt(4));

                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean Add(TaiKhoan tk) throws SQLException {
//        Connection con = Helper.DatabaseHelper.getDBConnect();
        String sql = "INSERT INTO taikhoan(taikhoan, matKhau, loaiTK, maNV) VALUES (?,?,?,?)";

        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  PreparedStatement stsm = conn.prepareStatement(sql);) {
            stsm.setString(1, tk.getTaiKhoan());
            stsm.setString(2, tk.getMatKhau());
            stsm.setString(3, tk.getLoaiTK());
            stsm.setInt(4, tk.getMaNV());

            return stsm.executeUpdate() > 0;
        }
    }

    public Boolean Update(TaiKhoan tk) throws SQLException {
        String sql = "UPDATE taikhoan SET matKhau = ?, loaiTK = ?, maNV = ? " + "WHERE taiKhoan = ?";
        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  PreparedStatement stsm = conn.prepareStatement(sql);) {
            stsm.setString(4, tk.getTaiKhoan());
            stsm.setString(1, tk.getMatKhau());
            stsm.setString(2, tk.getLoaiTK());
            stsm.setInt(3, tk.getMaNV());

            return stsm.executeUpdate() > 0;
        }
    }

    public Boolean Delete(String taikhoan) throws SQLException {
        String sql = "delete from taikhoan where taikhoan =? ";
        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  PreparedStatement pstm = conn.prepareStatement(sql);) {
            pstm.setString(1, taikhoan);
            return pstm.executeUpdate() > 0;
        }
    }

    public List<TaiKhoan> timListTaiKhoan(String taiKhoan) {
        List<TaiKhoan> list = new ArrayList<>();
        ResultSet rs = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM TAIKHOAN WHERE TAIKHOAN like '%" + taiKhoan + "%'";
            conn = Helper.DatabaseHelper.getDBConnect();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setTaiKhoan(rs.getString(1));
                tk.setMatKhau(rs.getString(2));
                tk.setLoaiTK(rs.getString(3));
                tk.setTenNV(rs.getString(4));
                list.add(tk);
                return list;
            }
        } catch (Exception e) {
            System.out.println("Loi khong tim thay tai khoan " + e.toString());
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

    public Boolean DoiMatKhau(TaiKhoan tk) throws SQLException {
        String sql = "Update taikhoan set matkhau = ? where taikhoan =?";

        try (
                 Connection conn = Helper.DatabaseHelper.getDBConnect();  PreparedStatement stsm = conn.prepareStatement(sql);) {
            stsm.setString(2, tk.getTaiKhoan());
            stsm.setString(1, tk.getMatKhau());

            return stsm.executeUpdate() > 0;
        }
    }
}

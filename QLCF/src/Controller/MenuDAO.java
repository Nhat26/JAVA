/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Menu;
import Helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRI
 */
public class MenuDAO {

    private static MenuDAO instance;

    public MenuDAO() {
    }

    public static MenuDAO getInstance() {
        if (instance == null) {
            instance = new MenuDAO();
        }
        return instance;
    }

    public static void setInstance(MenuDAO instance) {
        MenuDAO.instance = instance;
    }

    public List<Menu> GetListMenuByTableId(int id) {
        List<Menu> list = new ArrayList<Menu>();
        Connection con = DatabaseHelper.getDBConnect();
        try {
            PreparedStatement pstmt = con.prepareStatement("SELECT `loaihang`.`tenlh`, `cthoadon`.`soluong`, `loaihang`.`giathanhpham`, "
                    + "`cthoadon`.`soluong`*`loaihang`.`giathanhpham` AS totalPrice FROM `cthoadon`, `hoadon`, `loaihang` "
                    + "WHERE `cthoadon`.`maHD` = `hoadon`.`maHD` AND `cthoadon`.`maLH` = `loaihang`.`maLH` AND "
                    + "`hoadon`.`status` = 0 AND `hoaodn`.`maban` = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
                list.add(menu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Menu> GetListMenuByTableId(String idTable) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.TaiKhoan;
import java.sql.Connection;

/**
 *
 * @author THE LUC
 */
public class TestDB {

    public static void main(String[] args) {
        Connection conn = Helper.DatabaseHelper.getDBConnect();
        TaiKhoanDAO dao = new TaiKhoanDAO();
        try {
            if (conn != null) {
                System.out.println("Connect success!");
                TaiKhoan find = dao.timTaiKhoan("admin");
                if(find != null)
                {
                    System.out.println("Tim thay");
                    System.out.println(find.toString());
                }
                else{
                    System.out.println("Khong tim thay");
                }

            } else {
                System.out.println("connect that bai");
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

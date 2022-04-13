/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.sql.*;

/**
 *
 * @author THE LUC
 */
public class DatabaseHelper {

    public static final String connectionUrl = "jdbc:sqlserver://localhost;databaseName=QLCF;user=sa;password=123456;"
            + "encrypt=true;trustServerCertificate=true";

    public static Connection getDBConnect() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception e) {
            System.out.println("Chua co Driver!" + e.toString());
        }

        try {
            conn = DriverManager.getConnection(connectionUrl);
            return conn;
        } catch (Exception e) {
            System.out.println("Loi Connect" + e.toString());
        }

        return null;

    }

    public DatabaseHelper() {
    }

}

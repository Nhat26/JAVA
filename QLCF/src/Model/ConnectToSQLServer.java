/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.*;

/**
 *
 * @author THE LUC
 */
public class ConnectToSQLServer {

    public static void main(String[] args) {
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://localhost;databaseName=QLCF;user=sa;password=123456;" 
                                + "encrypt=true;trustServerCertificate=true";

        try ( Connection con = DriverManager.getConnection(connectionUrl);  Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM NHANVIEN";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("MANV") + " " + rs.getString("TENNV"));
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();

        }
    }

}

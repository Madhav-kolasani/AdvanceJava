package com.JDBC;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

public class JDBCExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/scott";
        String user = "root";
        String password = "MySQL@123";

        try {
            // REQUIRED for manual JAR setup
 
            try (Connection con = DriverManager.getConnection(url, user, password);
                 Statement stmt = con.createStatement()) {

                ResultSet rs = stmt.executeQuery("SELECT * FROM EMP");

                while (rs.next()) {
                    System.out.println(
                            rs.getInt("empno") + " " +
                            rs.getString("ename")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


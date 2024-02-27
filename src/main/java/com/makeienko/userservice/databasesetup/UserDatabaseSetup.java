package com.makeienko.userservice.databasesetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserDatabaseSetup {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("USE myDatabase");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (" +
                    "id BIGINT NOT NULL AUTO_INCREMENT," +
                    "username VARCHAR(255) UNIQUE," +
                    "password VARCHAR(255)," +
                    "PRIMARY KEY (id)" +
                    ")");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


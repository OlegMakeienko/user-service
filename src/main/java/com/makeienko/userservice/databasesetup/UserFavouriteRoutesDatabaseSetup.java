package com.makeienko.userservice.databasesetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserFavouriteRoutesDatabaseSetup {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate("USE myDatabase");

            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS user_favorite_routes (" +
                    "id BIGINT NOT NULL AUTO_INCREMENT," +
                    "user_id BIGINT NOT NULL," +
                    "route_id BIGINT NOT NULL," +
                    "PRIMARY KEY (id)," +
                    "FOREIGN KEY (user_id) REFERENCES users(id)," +
                    "FOREIGN KEY (route_id) REFERENCES communal_transport(id)" +
                    ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


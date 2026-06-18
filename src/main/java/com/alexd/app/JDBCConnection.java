package com.alexd.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static final String DATABASE = "jdbc:sqlite:database/AboutMe.db";

    public JDBCConnection() {
        IO.println("Created JDBCConnection Object to work with an ArrayList of Objects");
    }

    public static Connection testConnection() {
        try {
            return DriverManager.getConnection(DATABASE);
        } catch (SQLException e) {
            IO.println(e.getMessage());
            return null;
        }
    }
}

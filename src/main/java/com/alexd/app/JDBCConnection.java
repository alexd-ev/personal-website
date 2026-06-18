package com.alexd.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
    private static final String DATABASE = "jdbc:sqlite:database/AboutMe.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE);
    }
}

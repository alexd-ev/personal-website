package com.alexd.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class JDBCConnection {
    private static final String DATABASE = "jdbc:sqlite:database/AboutMe.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE);
    }

    public static Statement getStatement(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        return statement;
    }

    public static PreparedStatement getPreparedStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setQueryTimeout(30);
        return preparedStatement;
    }
}

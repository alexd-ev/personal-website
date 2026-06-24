package com.alexd.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;

/*
 * Utility class for managing the SQLite database connection.
 *
 * Provides helpers to open a connection and create statements with a reasonable
 * query timeout to avoid long-running database operations.
 */
public class JDBCConnection {
    private static final String DATABASE = "jdbc:sqlite:database/AboutMe.db";

    /**
     * Opens a new JDBC connection to the SQLite database.
     *
     * @return open database connection
     * @throws SQLException if the connection fails
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE);
    }

    /**
     * Creates a new Statement with a 30-second timeout.
     *
     * @param connection JDBC connection to use
     * @return configured Statement
     * @throws SQLException if statement creation fails
     */
    public static Statement getStatement(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        return statement;
    }

    /**
     * Creates a new PreparedStatement with a 30-second timeout.
     *
     * @param connection JDBC connection to use
     * @param sql        SQL query string
     * @return configured PreparedStatement
     * @throws SQLException if preparation fails
     */
    public static PreparedStatement getPreparedStatement(Connection connection, String sql) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setQueryTimeout(30);
        return preparedStatement;
    }
}

package com.alexd.app;

import java.sql.Connection;

public class App {
    void main() {
        Connection connection = JDBCConnection.testConnection();
    }
}

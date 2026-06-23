package com.alexd.app;

import java.util.HashMap;

import java.sql.Connection;
import java.sql.Statement;

import io.javalin.http.Handler;
import io.javalin.http.Context;

public class PageContact implements Handler {
    public static final String CONTACT_URL = "/contact";
    private static final String CONTACT_TEMPLATE = "templates/contact.html";

    @Override
    public void handle(Context context) throws Exception {
        try (Connection connection = JDBCConnection.getConnection();
                Statement statement = JDBCConnection.getStatement(connection)) {

            HashMap<String, Object> contactModel = new HashMap<>();
            context.render(CONTACT_TEMPLATE, contactModel);
        }
    }
}

package com.alexd.app;

import java.util.ArrayList;
import java.util.HashMap;

import java.sql.Connection;
import java.sql.Statement;

import io.javalin.http.Handler;
import io.javalin.http.Context;

public class PageIndex implements Handler {
    public static final String INDEX_URL = "/";
    private static final String INDEX_TEMPLATE = "templates/index.html";

    @Override
    public void handle(Context context) throws Exception {
        try (Connection connection = JDBCConnection.getConnection();
                Statement statement = JDBCConnection.getStatement(connection)) {

            HashMap<String, Object> indexModel = new HashMap<>();
            ArrayList<Course> courses = Course.loadAllCourses(statement);
            indexModel.put("courses", courses);
            context.render(INDEX_TEMPLATE, indexModel);
        }
    }
}

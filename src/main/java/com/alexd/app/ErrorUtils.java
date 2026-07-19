package com.alexd.app;

import java.util.HashMap;

import io.javalin.http.Context;

/*
 * Utility class for rendering error pages.
 *
 * Provides a consistent error model and response status for the error template.
 */
public class ErrorUtils {
    public static void renderDatabaseError(Context context, int status) {
        HashMap<String, Object> errorModel = new HashMap<>();
        errorModel.put("status", status);
        errorModel.put("title", "Database Error");
        errorModel.put("message", "Unable to connect to the database. Please try again later.");
        context.status(status).render("templates/error.html", errorModel);
    }

    public static void renderApplicationError(Context context, int status) {
        HashMap<String, Object> errorModel = new HashMap<>();
        errorModel.put("status", status);
        errorModel.put("title", "Application Error");
        errorModel.put("message", "Something went wrong on my end. Please try again later.");
        context.status(status).render("templates/error.html", errorModel);
    }
}

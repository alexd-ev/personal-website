package com.alexd.app;

import java.util.HashMap;

import io.javalin.http.Context;

/*
 * Utility class for rendering error pages.
 *
 * Provides a consistent error model and response status for the error template.
 */
public class ErrorUtils {
    public static void renderError(Context context, int status, String title, String message) {
        HashMap<String, Object> errorModel = new HashMap<>();
        errorModel.put("status", status);
        errorModel.put("title", title);
        errorModel.put("message", message);
        context.status(status).render("templates/error.html", errorModel);
    }
}

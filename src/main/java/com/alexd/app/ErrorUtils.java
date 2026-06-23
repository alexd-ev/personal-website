package com.alexd.app;

import java.util.HashMap;

import io.javalin.http.Context;

public class ErrorUtils {
    public static void renderError(Context context, int status, String title, String message) {
        HashMap<String, Object> errorModel = new HashMap<>();
        errorModel.put("status", status);
        errorModel.put("title", title);
        errorModel.put("message", message);
        context.status(status).render("templates/error.html", errorModel);
    }
}

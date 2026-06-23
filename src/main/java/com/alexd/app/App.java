package com.alexd.app;

import java.util.HashMap;

import java.sql.SQLException;

import io.javalin.Javalin;
import io.javalin.plugin.bundled.RouteOverviewPlugin;
import io.javalin.rendering.template.JavalinThymeleaf;
import io.javalin.http.Context;

public class App {
    public static final int JAVALIN_PORT = 7001;

    void main() {
        Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin(pluginConfig -> {
                pluginConfig.path = "/help/routes";
            }));
            config.staticFiles.add("public/");
            config.fileRenderer(new JavalinThymeleaf());
            config.routes.get(PageIndex.INDEX_URL, new PageIndex());
            config.routes.get(PageContact.CONTACT_URL, new PageContact());
            config.routes.post(PageContact.CONTACT_URL, new PageContactSubmit());
            config.routes.exception(SQLException.class, (e, context) -> {
                System.err.println(e.getMessage());
                renderError(context, 500, "Database Error",
                        "Unable to connect to the database. Please try again later.");
            });
            config.routes.exception(Exception.class, (e, context) -> {
                System.err.println(e.getMessage());
                renderError(context, 500, "Application Error", "Something went wrong on our end.");
            });
        }).start(JAVALIN_PORT);
    }

    private void renderError(Context context, int status, String title, String message) {
        HashMap<String, Object> errorModel = new HashMap<>();
        errorModel.put("status", status);
        errorModel.put("title", title);
        errorModel.put("message", message);
        context.status(status).render("templates/error.html", errorModel);
    }
}

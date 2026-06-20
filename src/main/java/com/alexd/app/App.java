package com.alexd.app;

import java.sql.SQLException;

import io.javalin.Javalin;
import io.javalin.plugin.bundled.RouteOverviewPlugin;
import io.javalin.rendering.template.JavalinThymeleaf;

public class App {
    public static final int JAVALIN_PORT = 7000;

    void main() {
        Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin(pluginConfig -> {
                pluginConfig.path = "/help/routes";
            }));
            config.staticFiles.add("public/");
            config.fileRenderer(new JavalinThymeleaf());
            config.routes.get(PageIndex.INDEX_URL, new PageIndex());
            config.routes.exception(SQLException.class, (e, context) -> {
                System.err.println(e.getMessage());
                context.status(500).html("<h2>Database Error</h2>");
            });
            config.routes.exception(Exception.class, (e, context) -> {
                System.err.println(e.getMessage());
                context.status(500).html("<h2>Application Error</h2>");
            });
        }).start(JAVALIN_PORT);
    }
}

package com.alexd.app;

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
            config.routes.exception(java.sql.SQLException.class, (e, context) -> {
                System.err.println(e.getMessage());
                context.status(500).html("""
                        <div style='text-align:center; padding-top:50px; font-family:sans-serif;'>
                            <h2>System Maintenance</h2>
                            <p>My portfolio database is refreshing. Please wait a brief moment and
                            reload.</p>
                        </div>
                        """);
            });
        }).start(JAVALIN_PORT);
    }
}

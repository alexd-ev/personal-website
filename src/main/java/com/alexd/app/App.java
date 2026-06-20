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
        }).start(JAVALIN_PORT);
    }
}

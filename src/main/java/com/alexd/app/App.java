package com.alexd.app;

import java.sql.SQLException;

import io.javalin.Javalin;
import io.javalin.plugin.bundled.RouteOverviewPlugin;
import io.javalin.rendering.template.JavalinThymeleaf;

/*
 * Main application class for the personal website.
 *
 * This class configures and starts the Javalin web server, registers static
 * files, Thymeleaf rendering, page routes, and global exception handlers.
 */
public class App {
    public static final int JAVALIN_PORT = 7001;

    /*
     * Bootstrap method for the Javalin web application.
     *
     * The method configures the embedded server, route mappings, and error
     * handling.
     */
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
                ErrorUtils.renderDatabaseError(context, 500);
            });
            config.routes.exception(Exception.class, (e, context) -> {
                System.err.println(e.getMessage());
                ErrorUtils.renderApplicationError(context, 500);
            });
        }).start(JAVALIN_PORT);
    }
}

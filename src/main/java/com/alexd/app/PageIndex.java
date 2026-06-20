package com.alexd.app;

import java.util.HashMap;

import io.javalin.http.Handler;
import io.javalin.http.Context;

public class PageIndex implements Handler {
    public static final String INDEX_URL = "/";
    private static final String INDEX_TEMPLATE = "templates/index.html";

    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> indexModel = new HashMap<>();
        context.render(INDEX_TEMPLATE, indexModel);
    }
}

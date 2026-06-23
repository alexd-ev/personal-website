package com.alexd.app;

import java.util.HashMap;

import io.javalin.http.Handler;
import io.javalin.http.Context;

public class PageContact implements Handler {
    public static final String CONTACT_URL = "/contact";
    private static final String CONTACT_TEMPLATE = "templates/contact.html";

    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> contactModel = new HashMap<>();
        String successParam = context.queryParam("success");
        String errorParam = context.queryParam("error");
        if ("true".equals(successParam)) {
            contactModel.put("success", "Your message was sent successfully! I will get back to you soon.");
        }
        if (errorParam != null) {
            contactModel.put("error", errorParam);
        }
        context.render(CONTACT_TEMPLATE, contactModel);
    }
}

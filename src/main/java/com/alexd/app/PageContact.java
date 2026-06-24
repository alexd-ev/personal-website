package com.alexd.app;

import java.util.HashMap;
import java.util.UUID;

import io.javalin.http.Handler;
import io.javalin.http.Context;

/*
 * Handler for the contact page.
 *
 * Renders the contact form and optionally displays success or error feedback
 * based on query parameters returned after form submission.
 */
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
        // Generate a per-session CSRF token and expose it to the form
        String csrfToken = UUID.randomUUID().toString();
        context.sessionAttribute("csrfToken", csrfToken);
        contactModel.put("csrfToken", csrfToken);
        context.render(CONTACT_TEMPLATE, contactModel);
    }
}

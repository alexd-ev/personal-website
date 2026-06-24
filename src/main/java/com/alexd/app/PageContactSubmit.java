package com.alexd.app;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import java.sql.Connection;
import java.sql.PreparedStatement;

import io.javalin.http.Handler;
import io.javalin.http.Context;

/*
 * Handler for contact form submissions.
 *
 * Validates form input, inserts a new contact message into the database,
 * and redirects back to the contact page with a success or error message.
 */
public class PageContactSubmit implements Handler {
    public void handle(Context context) throws Exception {
        String messageInsert = "INSERT INTO contact_messages (name, email, subject, message, submitted_at) VALUES (?, ?, ?, ?, ?)";

        // Honeypot spam field check
        String honeypot = context.formParam("website");
        if (honeypot != null && !honeypot.trim().isEmpty()) {
            String spamError = URLEncoder.encode("Spam detected.", StandardCharsets.UTF_8);
            context.redirect("/contact?error=" + spamError);
            return;
        }

        // CSRF token validation
        String sessionCsrf = context.sessionAttribute("csrfToken");
        String formCsrf = context.formParam("_csrf");
        if (sessionCsrf == null || formCsrf == null || !sessionCsrf.equals(formCsrf)) {
            String invalidError = URLEncoder.encode("Invalid form submission.", StandardCharsets.UTF_8);
            context.redirect("/contact?error=" + invalidError);
            return;
        }
        try (Connection connection = JDBCConnection.getConnection();
                PreparedStatement preparedStatement = JDBCConnection.getPreparedStatement(connection, messageInsert)) {

            String name = context.formParam("name");
            String email = context.formParam("email");
            String subject = context.formParam("subject");
            String message = context.formParam("message");
            if (name == null || email == null || message == null || name.isEmpty() || email.isEmpty()
                    || message.isEmpty()) {
                String fieldsEmptyError = URLEncoder.encode("Name, email, and message are required fields.",
                        StandardCharsets.UTF_8);
                context.redirect("/contact?error=" + fieldsEmptyError);
                return;
            }
            String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            if (!email.matches(emailRegex)) {
                String invalidEmailError = URLEncoder.encode("Please enter a valid email address.",
                        StandardCharsets.UTF_8);
                context.redirect("/contact?error=" + invalidEmailError);
                return;
            }
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);

            if (subject == null || subject.trim().isEmpty()) {
                preparedStatement.setString(3, null);
            } else {
                preparedStatement.setString(3, subject);
            }
            preparedStatement.setString(4, message);

            preparedStatement.setString(5, DateTimeUtils.formatLocalDateTime("Australia/Melbourne"));
            preparedStatement.executeUpdate();
            // Invalidate the CSRF token after successful use
            context.sessionAttribute("csrfToken", null);
            context.redirect("/contact?success=true");
        }
    }
}

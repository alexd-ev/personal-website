package com.alexd.app;

import io.javalin.http.Context;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.InjectMocks;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TestContactSubmit {
    @Mock
    private Context context;

    @InjectMocks
    private PageContactSubmit controller;

    @Test
    void testSuccessfulContactSubmit() throws Exception {
        // A valid request should redirect the user to the success state.
        setupValidSecurityAndHoneypot();
        when(context.formParam("name")).thenReturn("Alex");
        when(context.formParam("email")).thenReturn("alex@example.com");
        when(context.formParam("subject")).thenReturn("");
        when(context.formParam("message")).thenReturn("Hello, this is a test message.");

        controller.handle(context);

        verify(context).redirect("/contact?success=true");
    }

    @Test
    void testNameEmptyContactSubmit() throws Exception {
        setupValidSecurityAndHoneypot();
        when(context.formParam("name")).thenReturn("");
        when(context.formParam("email")).thenReturn("alex@example.com");
        when(context.formParam("subject")).thenReturn("");
        when(context.formParam("message")).thenReturn("Hello, this is a test message.");

        controller.handle(context);

        assertRedirectedWithError("Name, email, and message are required fields.");
    }

    @Test
    void testEmailEmptyContactSubmit() throws Exception {
        setupValidSecurityAndHoneypot();
        when(context.formParam("name")).thenReturn("Alex");
        when(context.formParam("email")).thenReturn("");
        when(context.formParam("subject")).thenReturn("");
        when(context.formParam("message")).thenReturn("Hello, this is a test message.");

        controller.handle(context);

        assertRedirectedWithError("Name, email, and message are required fields.");
    }

    @Test
    void testMessageEmptyContactSubmit() throws Exception {
        setupValidSecurityAndHoneypot();
        when(context.formParam("name")).thenReturn("Alex");
        when(context.formParam("email")).thenReturn("alextest@example.com");
        when(context.formParam("subject")).thenReturn("");
        when(context.formParam("message")).thenReturn("");
        when(context.formParam("website")).thenReturn("");

        controller.handle(context);

        assertRedirectedWithError("Name, email, and message are required fields.");
    }

    @Test
    void testEmailInvalidContactSubmit() throws Exception {
        setupValidSecurityAndHoneypot();
        when(context.formParam("name")).thenReturn("Alex");
        when(context.formParam("email")).thenReturn("invalid-email");
        when(context.formParam("subject")).thenReturn("");
        when(context.formParam("message")).thenReturn("Hello, this is a test message.");

        controller.handle(context);

        assertRedirectedWithError("Please enter a valid email address.");
    }

    @Test
    void testHoneypotSpam() throws Exception {
        // The honeypot field should trigger spam handling immediately.
        when(context.formParam("website")).thenReturn("http://spammy-site.com");

        controller.handle(context);

        assertRedirectedWithError("Spam detected.");
    }

    @Test
    void testCSRFSessionInvalidContactSubmit() throws Exception {
        // A mismatched CSRF token should be rejected before any persistence happens.
        when(context.sessionAttribute("csrfToken")).thenReturn("valid-session-token");
        when(context.formParam("_csrf")).thenReturn("hacker-form-token");
        when(context.formParam("website")).thenReturn("");

        controller.handle(context);

        assertRedirectedWithError("Invalid form submission.");
    }

    private void setupValidSecurityAndHoneypot() {
        // Shared setup for tests that exercise the normal validation path.
        when(context.formParam("website")).thenReturn("");
        String fakeToken = "abc-123-xyz";
        when(context.sessionAttribute("csrfToken")).thenReturn(fakeToken);
        when(context.formParam("_csrf")).thenReturn(fakeToken);
    }

    private void assertRedirectedWithError(String message) {
        String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8);
        verify(context).redirect("/contact?error=" + encodedMessage);
    }
}

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
        when(context.formParam("name")).thenReturn("Alex");
        when(context.formParam("email")).thenReturn("alex@example.com");
        when(context.formParam("subject")).thenReturn("");
        when(context.formParam("message")).thenReturn("Hello, this is a test message.");
        when(context.formParam("website")).thenReturn("");
        String fakeToken = "abc-123-xyz";
        when(context.sessionAttribute("csrfToken")).thenReturn(fakeToken);
        when(context.formParam("_csrf")).thenReturn(fakeToken);
        controller.handle(context);
        verify(context).redirect("/contact?success=true");
    }

    @Test
    void testNameEmptyContactSubmit() throws Exception {
        when(context.formParam("name")).thenReturn("");
        when(context.formParam("email")).thenReturn("alex@example.com");
        when(context.formParam("subject")).thenReturn("");
        when(context.formParam("message")).thenReturn("Hello, this is a test message.");
        when(context.formParam("website")).thenReturn("");
        String fakeToken = "abc-123-xyz";
        when(context.sessionAttribute("csrfToken")).thenReturn(fakeToken);
        when(context.formParam("_csrf")).thenReturn(fakeToken);
        controller.handle(context);
        String fieldsEmptyError = URLEncoder.encode("Name, email, and message are required fields.",
                StandardCharsets.UTF_8);
        verify(context).redirect("/contact?error=" + fieldsEmptyError);
    }

    @Test
    void testEmailEmptyContactSubmit() throws Exception {
        when(context.formParam("name")).thenReturn("Alex");
        when(context.formParam("email")).thenReturn("");
        when(context.formParam("subject")).thenReturn("");
        when(context.formParam("message")).thenReturn("Hello, this is a test message.");
        when(context.formParam("website")).thenReturn("");
        String fakeToken = "abc-123-xyz";
        when(context.sessionAttribute("csrfToken")).thenReturn(fakeToken);
        when(context.formParam("_csrf")).thenReturn(fakeToken);
        controller.handle(context);
        String fieldsEmptyError = URLEncoder.encode("Name, email, and message are required fields.",
                StandardCharsets.UTF_8);
        verify(context).redirect("/contact?error=" + fieldsEmptyError);
    }

    @Test
    void testMessageEmptyContactSubmit() throws Exception {
        when(context.formParam("name")).thenReturn("Alex");
        when(context.formParam("email")).thenReturn("");
        when(context.formParam("subject")).thenReturn("");
        when(context.formParam("message")).thenReturn("");
        when(context.formParam("website")).thenReturn("");
        String fakeToken = "abc-123-xyz";
        when(context.sessionAttribute("csrfToken")).thenReturn(fakeToken);
        when(context.formParam("_csrf")).thenReturn(fakeToken);
        controller.handle(context);
        String fieldsEmptyError = URLEncoder.encode("Name, email, and message are required fields.",
                StandardCharsets.UTF_8);
        verify(context).redirect("/contact?error=" + fieldsEmptyError);
    }

    @Test
    void testEmailInvalidContactSubmit() throws Exception {
        when(context.formParam("name")).thenReturn("Alex");
        when(context.formParam("email")).thenReturn("invalid-email");
        when(context.formParam("subject")).thenReturn("");
        when(context.formParam("message")).thenReturn("Hello, this is a test message.");
        when(context.formParam("website")).thenReturn("");
        String fakeToken = "abc-123-xyz";
        when(context.sessionAttribute("csrfToken")).thenReturn(fakeToken);
        when(context.formParam("_csrf")).thenReturn(fakeToken);
        controller.handle(context);
        String invalidEmailError = URLEncoder.encode("Please enter a valid email address.", StandardCharsets.UTF_8);
        verify(context).redirect("/contact?error=" + invalidEmailError);
    }

    @Test
    void testHoneypotSpam() throws Exception {
        when(context.formParam("website")).thenReturn("http://spammy-site.com");
        controller.handle(context);
        String spamError = URLEncoder.encode("Spam detected.", StandardCharsets.UTF_8);
        verify(context).redirect("/contact?error=" + spamError);
    }

    @Test
    void testCSRFSessionInvalidContactSubmit() throws Exception {
        when(context.sessionAttribute("csrfToken")).thenReturn("valid-session-token");
        when(context.formParam("_csrf")).thenReturn("hacker-form-token");
        when(context.formParam("website")).thenReturn("");
        controller.handle(context);
        String invalidError = URLEncoder.encode("Invalid form submission.", StandardCharsets.UTF_8);
        verify(context).redirect("/contact?error=" + invalidError);
    }
}

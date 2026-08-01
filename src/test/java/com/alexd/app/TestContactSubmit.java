package com.alexd.app;

import io.javalin.http.Context;

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
}

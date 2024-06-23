package com.example.jersey;

import com.example.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LoginResourceTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    private LoginResource loginResource;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        loginResource = new LoginResource();
    }

    @Test
    public void testLoginSuccess() {
        when(request.getSession(true)).thenReturn(session);

        Response response = loginResource.login(request, "admin", "password");

        verify(session).setAttribute(eq("user"), any(User.class));
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testLoginFailure() {
        Response response = loginResource.login(request, "admin", "wrongpassword");

        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }
}

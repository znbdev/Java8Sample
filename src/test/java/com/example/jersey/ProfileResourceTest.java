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
import static org.mockito.Mockito.when;

public class ProfileResourceTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    private ProfileResource profileResource;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        profileResource = new ProfileResource();
    }

    @Test
    public void testGetProfileSuccess() {
        User user = new User(1, "ADMIN");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(user);

        Response response = profileResource.getProfile(request);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(user, response.getEntity());
    }

    @Test
    public void testGetProfileUnauthorized() {
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("user")).thenReturn(null);

        Response response = profileResource.getProfile(request);

        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }

    @Test
    public void testGetProfileNoSession() {
        when(request.getSession(false)).thenReturn(null);

        Response response = profileResource.getProfile(request);

        assertEquals(Response.Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
    }
}

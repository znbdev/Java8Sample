package com.example.jersey;

import com.example.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public class LoginResource {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@Context HttpServletRequest request,
                          @javax.ws.rs.FormParam("username") String username,
                          @javax.ws.rs.FormParam("password") String password) {

        if ("admin".equals(username) && "password".equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", new User(1, "ADMIN"));

            return Response.status(Response.Status.OK)
                    .entity("<html><body>Login successful!<br><a href=\"../menu.html\">Go to menu</a></body></html>")
                    .type(MediaType.TEXT_HTML)
                    .build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid username or password")
                    .build();
        }
    }
}

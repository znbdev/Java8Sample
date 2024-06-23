package com.example.jersey;

import com.example.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/profile")
public class ProfileResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfile(@Context HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                return Response.ok(user).build();
            }
        }
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}

package com.example.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void testUser() {
        User user = new User(1, "ADMIN");
        assertEquals(1, user.getUserId());
        assertEquals("ADMIN", user.getUserRole());

        user.setUserId(2);
        user.setUserRole("USER");
        assertEquals(2, user.getUserId());
        assertEquals("USER", user.getUserRole());
    }
}

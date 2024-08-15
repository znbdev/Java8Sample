package com.example.jersey;

import com.example.entity.Customer;
import com.example.service.mybatis.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/customers")
public class CustomerResource {

    @Inject
    private CustomerService customerService;

    @GET
    @Path("/{id}")
    public Customer getCustomerById(@PathParam("id") int id) {
        return customerService.getCustomerById(id);
    }
}


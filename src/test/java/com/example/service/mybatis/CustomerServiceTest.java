package com.example.service.mybatis;

import com.example.entity.Customer;
import com.example.mapper.CustomerMapper;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.Assert;
import org.junit.Test;

import javax.servlet.http.HttpSession;

public class CustomerServiceTest {

    @Mocked
    CustomerMapper customerMapper;

    @Mocked
    HttpSession session;

    @Test
    public void testGetCustomerById() {
        Customer expectedCustomer = new Customer(1, "John Doe");

        new Expectations() {{
            customerMapper.findById(1);
            result = expectedCustomer;
            session.setAttribute("currentCustomer", expectedCustomer);
        }};

        CustomerService customerService = new CustomerService(customerMapper, session);
        Customer actualCustomer = customerService.getCustomerById(1);

        Assert.assertEquals(expectedCustomer, actualCustomer);

        new Verifications() {{
            customerMapper.findById(1); times = 1;
            session.setAttribute("currentCustomer", expectedCustomer); times = 1;
        }};
    }

    @Test
    public void testLogout() {
        new Expectations() {{
            session.invalidate();
        }};

        CustomerService customerService = new CustomerService(customerMapper, session);
        customerService.logout();

        new Verifications() {{
            session.invalidate(); times = 1;
        }};
    }
}
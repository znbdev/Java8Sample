package com.example.service.mybatis;

import com.example.entity.Customer;
import com.example.mapper.CustomerMapper;

import javax.servlet.http.HttpSession;

public class CustomerService {

    private CustomerMapper customerMapper;
    private HttpSession session;

    public CustomerService(CustomerMapper customerMapper, HttpSession session) {
        this.customerMapper = customerMapper;
        this.session = session;
    }

    public Customer getCustomerById(int customerId) {
        Customer customer = customerMapper.findById(customerId);
        if (customer != null) {
            session.setAttribute("currentCustomer", customer);
        }
        return customer;
    }

    public void logout() {
        session.invalidate();
    }
}

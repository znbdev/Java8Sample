package com.example.mapper;

import com.example.entity.Customer;
import org.apache.ibatis.annotations.Select;

public interface CustomerMapper {
    @Select("SELECT * FROM customers WHERE id = #{id}")
    Customer findById(int id);
}
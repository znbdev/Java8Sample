package com.example.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItemBean {
    private String text1;
    private String text2;
    private Integer number;
    private BigDecimal amount;

    public ItemBean(String text1, String text2, Integer number, BigDecimal amount) {
        this.text1 = text1;
        this.text2 = text2;
        this.number = number;
        this.amount = amount;
    }
}
package com.example.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DataItemBean {
    private String text;
    private Integer number;

    public DataItemBean(String text, Integer number) {
        this.text = text;
        this.number = number;
    }

    public boolean isValid() {
        if (text == null || text.length() < 2 || text.length() > 10) {
            return false;
        }
        return number != null && number.toString().length() == 5;
    }
}

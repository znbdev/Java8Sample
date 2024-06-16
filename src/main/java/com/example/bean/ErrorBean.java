package com.example.bean;

import lombok.Data;

@Data
public class ErrorBean {
    private String fieldName;
    private String errorCode;
    private String errorMessage;

    // 构造函数
    public ErrorBean(String fieldName, String errorCode, String errorMessage) {
        this.fieldName = fieldName;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    // toString 方法
    @Override
    public String toString() {
        return "ErrorBean{" +
                "projectName='" + fieldName + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
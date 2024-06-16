package com.example.entity;

import com.example.validator.ValidTrue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyEntity {
    @ValidTrue(fieldName = "myField", errorCode = "E01", errorMessage = "myField 不能为空")
    private String myField;
    @ValidTrue(fieldName = "otherField", errorCode = "E01", errorMessage = "myField 不能为空")
    private String otherField;

    // 其他字段...
}
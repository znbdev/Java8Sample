package com.example;

import com.example.bean.User;
import com.example.validator.CustomTypeValidator;
import com.example.validator.FieldValidator;
import com.example.validator.LengthValidator;
import com.example.validator.NotNullValidator;

import java.util.Arrays;
import java.util.List;

public class Java8Demo {
    public static void forEachDemo() {
        List<String> list = Arrays.asList("A1", "B2", "C3", "D5", "11", "22", "33", "44");

        List<Integer> integerList = Arrays.asList(1, 2, 3, 5, 11, 22, 33, 44);

        //跳出本次循环
        for (Integer integer : integerList) {
            if (integer > 11) {
                continue;
            }
            System.out.println("普通forEach循环 " + integer);
        }

        //java 8跳出本次循环
        integerList.stream().forEach(e -> {
            if (e > 11) {
                return;
            }
            System.out.println("lambda forEach循环 " + e);
        });
    }

    public static void validator() {
        User user = new User("John", 25);

        FieldValidator nameValidator = new FieldValidator(user.getName())
                .addValidator(new NotNullValidator(), Object.class)
                .addValidator(new LengthValidator(3, 50), String.class);

        FieldValidator ageValidator = new FieldValidator(user.getAge())
                .addValidator(new NotNullValidator(), Object.class)
                .addValidator(new CustomTypeValidator<>(Integer.class), Object.class);

        List<String> nameErrors = nameValidator.validate();
        List<String> ageErrors = ageValidator.validate();

        if (nameErrors.isEmpty() && ageErrors.isEmpty()) {
            System.out.println("User is valid");
        } else {
            System.out.println("Validation errors:");
            nameErrors.forEach(System.out::println);
            ageErrors.forEach(System.out::println);
        }
    }

}

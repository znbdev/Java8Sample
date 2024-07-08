package com.example.check;

import com.example.bean.ItemBean;

import java.util.Objects;
import java.util.stream.Stream;

public class NullCheckExample {
    public static void main(String[] args) {
        ItemBean itemBean = new ItemBean();
        boolean anyNullOrEmpty = Stream.of(itemBean.getText1(), itemBean.getText2())
                .anyMatch(text -> Objects.isNull(text) || text.isEmpty());
        boolean numberIsNull = Objects.isNull(itemBean.getNumber());

        if (anyNullOrEmpty || numberIsNull) {
            System.out.println("One or more fields are null or empty");
        } else {
            System.out.println("All fields are non-null and non-empty");
        }

        String var1 = "Hello";
        String var2 = null;
        String var3 = "World";

        boolean anyNull = Stream.of(var1, var2, var3).anyMatch(Objects::isNull);
        boolean allNull = Stream.of(var1, var2, var3).allMatch(Objects::isNull);

        System.out.println("Is any variable null? " + anyNull); // 输出: true
        System.out.println("Are all variables null? " + allNull); // 输出: false
    }
}

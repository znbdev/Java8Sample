package com.example.check;

import java.util.Objects;
import java.util.stream.Stream;

public class NullCheckExample {
    public static void main(String[] args) {
        String var1 = "Hello";
        String var2 = null;
        String var3 = "World";

        boolean anyNull = Stream.of(var1, var2, var3).anyMatch(Objects::isNull);
        boolean allNull = Stream.of(var1, var2, var3).allMatch(Objects::isNull);

        System.out.println("Is any variable null? " + anyNull); // 输出: true
        System.out.println("Are all variables null? " + allNull); // 输出: false
    }
}

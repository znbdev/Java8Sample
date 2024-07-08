package com.example.check;

import java.util.stream.Stream;

public class EmptyCheckExample {
    public static void main(String[] args) {
        String var1 = "Hello";
        String var2 = "";
        String var3 = "World";

        boolean anyEmpty = Stream.of(var1, var2, var3).anyMatch(String::isEmpty);
        boolean allEmpty = Stream.of(var1, var2, var3).allMatch(String::isEmpty);

        System.out.println("Is any variable empty? " + anyEmpty); // 输出: true
        System.out.println("Are all variables empty? " + allEmpty); // 输出: false
    }
}


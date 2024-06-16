package com.example;

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
}

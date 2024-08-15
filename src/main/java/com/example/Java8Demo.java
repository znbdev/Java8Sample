package com.example;

import com.example.annotation.AnnotationValidator;
import com.example.bean.ItemBean;
import com.example.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
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

    public static void userValidator() {
        User user = new User("John", 25);
        AnnotationValidator validator = new AnnotationValidator();

        List<String> errors = validator.validate(user);

        if (errors.isEmpty()) {
            System.out.println("User is valid");
        } else {
            System.out.println("Validation errors:");
            errors.forEach(System.out::println);
        }

    }

    public static void sortListDemo() {
        List<ItemBean> itemBeanList = Arrays.asList(
                new ItemBean("2", "1", 10, new BigDecimal("10.00"))
                , new ItemBean("1", "2", 20, new BigDecimal("10.00"))
                , new ItemBean("1", "1", 20, new BigDecimal("10.00"))
                , new ItemBean("1", "1", 20, new BigDecimal("20.00"))
                , new ItemBean("1", "1", 20, new BigDecimal("30.00")));
        log.info("排序前：");
        for (int i = 0; i < itemBeanList.size(); i++) {
            log.info("第{}行: {}", i + 1, itemBeanList.get(i));
        }

        // itemBeanList排序，text1升序,text2升序,number降序,amount升序
        itemBeanList = itemBeanList.stream()
                .sorted(Comparator.comparing(ItemBean::getText1, Comparator.nullsFirst(String::compareTo))
                        .thenComparing(ItemBean::getText2, Comparator.nullsFirst(String::compareTo))
                        .thenComparing(Comparator.comparing(ItemBean::getNumber).reversed())
                        .thenComparing(ItemBean::getAmount, Comparator.nullsFirst(BigDecimal::compareTo)))
                .collect(Collectors.toList());
        log.info("排序后：");
        for (int i = 0; i < itemBeanList.size(); i++) {
            log.info("第{}行: {}", i + 1, itemBeanList.get(i));
        }

        // 如果不需要 nullsFirst 设定，并且你确定所有字段都不会为 null，或者你希望 null 值按默认的自然顺序处理，那么可以直接移除 Comparator.nullsFirst，
        // 让 Comparator.comparing 按照字段的自然顺序进行排序。
        itemBeanList = itemBeanList.stream()
                .sorted(Comparator.comparing(ItemBean::getText1)
                        .thenComparing(ItemBean::getText2)
                        .thenComparing(Comparator.comparing(ItemBean::getNumber).reversed())
                        .thenComparing(ItemBean::getAmount))
                .collect(Collectors.toList());
        log.info("排序后：");
        for (int i = 0; i < itemBeanList.size(); i++) {
            log.info("第{}行: {}", i + 1, itemBeanList.get(i));
        }
    }
}

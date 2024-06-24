package com.example.generator;

import java.io.*;
import java.nio.file.*;

public class JavaClassGenerator {

    public static void main(String[] args) {
        String templateFilePath = "src/main/java/com/example/JavaTemplate.java"; // 模板文件路径
        String outputDir = "output_classes"; // 输出目录

        try {
            // 读取模板文件内容
            String templateContent = new String(Files.readAllBytes(Paths.get(templateFilePath)));

            // 创建输出目录
            Files.createDirectories(Paths.get(outputDir));

            // 生成10个Java类文件
            for (int i = 1; i <= 10; i++) {
                String className = "Java" + i + "Demo";
                String javaContent = templateContent.replace("JavaTemplate", className);
                String filePath = outputDir + "/" + className + ".java";
                Files.write(Paths.get(filePath), javaContent.getBytes());
            }

            System.out.println("Generated 10 Java classes in " + outputDir + " directory.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

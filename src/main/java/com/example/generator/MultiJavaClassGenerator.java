package com.example.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MultiJavaClassGenerator {

    private static final String templateFilePath1 = "src/main/java/com/example/generator/bean/JavaTemplateBean.java";
    private static final String templateFilePath2 = "src/main/java/com/example/generator/dao/JavaTemplateDao.java";
    private static final String key  = "800";

    public static void main(String[] args) {
        List<String> templateFilePaths = Arrays.asList(templateFilePath1, templateFilePath2); // 模板文件路径列表
        String outputDir = "output_classes"; // 输出目录

        try {
            // 创建输出目录
            Files.createDirectories(Paths.get(outputDir));

            // 遍历模板文件路径
            for (String templateFilePath : templateFilePaths) {
                // 读取模板文件内容
                String templateContent = new String(Files.readAllBytes(Paths.get(templateFilePath)));

                // 获取模板文件名并去掉扩展名
                String templateFileName = Paths.get(templateFilePath).getFileName().toString().replace(".java", "");

                String className = templateFileName.replace("Template", key + "Demo");

                String javaContent = templateContent.replaceAll(templateFileName, className);
                javaContent = javaContent.replaceAll("Java900Template", "Java" + key + "Template");
                javaContent = javaContent.replaceAll("java900Template", "java" + key + "Template");

                // 使用正则表达式来匹配整个单词
//                String javaContent = templateContent.replaceAll(templateFileName, className);
//                javaContent = javaContent.replaceAll("\\b" + "Java900Template" + "\\b", "Java" + key + "Template");
//                javaContent = javaContent.replaceAll("\\b" + "java900Template" + "\\b", "java" + key + "Template");

                String filePath = outputDir + "/" + className + ".java";
                Files.write(Paths.get(filePath), javaContent.getBytes());

                // 生成10个Java类文件
//                for (int i = 1; i <= 10; i++) {
//                    String className = templateFileName.replace("Template", i + "Demo");
//                    String javaContent = templateContent.replaceAll(templateFileName, className);
//                    javaContent = javaContent.replaceAll("JavaTemplate1", "JavaTemplate" + i);
//                    javaContent = javaContent.replaceAll("javaTemplate1", "javaTemplate" + i);
//
//                    String filePath = outputDir + "/" + className + ".java";
//                    Files.write(Paths.get(filePath), javaContent.getBytes());
//                }
            }

            System.out.println("Generated Java classes in " + outputDir + " directory.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

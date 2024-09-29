package com.example;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@Slf4j
public class JsonFileReader {

    public static void main(String[] args) throws IOException {
        // 替换为你的本地文件路径 或者 "./test.json" 作为相对路径
        // For Windows
//        String filePath = "C:/path/to/your/test.json";
        // For Mac or Linux
        String filePath = "/Users/znb/workspace/Java8Sample/src/main/resources/test.json";
        // 读取test.json文件为字符串
        String jsonContentFromLocal = readFileContent(filePath);
        log.info("jsonContentFromLocal: {}", jsonContentFromLocal);

        // 读取Resources目录下的test.json文件为字符串
        String jsonContentFromResources = readFileFromResources("tmp/test.json");
        log.info("jsonContentFromResources: {}", jsonContentFromResources);
    }

    public static String readFileFromResources(String fileName) throws IOException {
        // 获取ClassLoader，获取resources目录中的文件
        ClassLoader classLoader = JsonFileReader.class.getClassLoader();
        // 获取文件的路径
        String filePath = Objects.requireNonNull(classLoader.getResource(fileName)).getPath();
        // 读取文件内容并将其转换为字符串
        return readFileContent(filePath);
    }

    public static String readFileContent(String filePath) throws IOException {
        // 读取文件内容并将其转换为字符串
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}


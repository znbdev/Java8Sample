package com.example;

import org.junit.Test;

import java.io.IOException;

public class JsonFileReaderTest {

    @Test
    public void testReadFileFromResources() throws IOException {
        String jsonContent = JsonFileReader.readFileFromResources("test.json");
        System.out.println(jsonContent);
    }

    @Test
    public void testReadFileContent() throws IOException {
        // For Windows
//        String filePath = "C:/path/to/your/test.json";
        // For Mac or Linux
        String filePath = "/Users/znb/workspace/Java8Sample/src/main/resources/test.json";
        // 读取test.json文件为字符串
        String jsonContent = JsonFileReader.readFileContent(filePath);
        System.out.println(jsonContent);
    }
}
package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class JsonFileReaderTest {

    @Value("${test.json.filePath}")
    private String testJsonFilePath;

    @Test
    void testReadFileFromResources() throws IOException {
        String jsonContent = JsonFileReader.readFileFromResources("test.json");
        System.out.println(jsonContent);
    }

    @Test
    void testReadFileContent() throws IOException {
        // 使用application-test.properties中指定的路径
        String filePath = System.getProperty("user.dir") + "/" + testJsonFilePath;
        // 读取test.json文件为字符串
        String jsonContent = JsonFileReader.readFileContent(filePath);
        System.out.println(jsonContent);
    }
}

package com.example.springbootdemo;

import com.example.springbootdemo.service.ChatGPTService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringBootDemoApplicationTests {

    @Autowired
    ChatGPTService chatGPTService;

    @Test
    void contextLoads() throws IOException {
        chatGPTService.generateResponse("java 实现冒泡");
    }

}

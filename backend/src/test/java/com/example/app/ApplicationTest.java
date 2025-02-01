package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Application;

@SpringBootTest(classes = Application.class)  // Aponte para a classe principal
class ApplicationTest {

    @Test
    void contextLoads() {
    }
}

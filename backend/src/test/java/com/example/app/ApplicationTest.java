package com.example.productmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Application;

@SpringBootTest(classes = Application.class)  // Aponte para a classe principal
class ApplicationTests {

    @Test
    void contextLoads() {
    }
}

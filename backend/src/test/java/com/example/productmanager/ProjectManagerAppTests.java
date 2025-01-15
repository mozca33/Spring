package com.example.productmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.projectmanager.ProjectManagerApp;

@SpringBootTest(classes = ProjectManagerApp.class)  // Aponte para a classe principal
class ProjectManagerAppTests {

    @Test
    void contextLoads() {
    }
}

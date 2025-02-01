package com.example.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ApiController {
    @GetMapping("message")
    public ResponseEntity<String> obtainMessage() {
        return ResponseEntity.ok("Hello from the backend");
    }
}

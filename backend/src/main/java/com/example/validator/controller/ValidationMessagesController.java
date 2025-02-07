package com.example.validator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.validator.ValidationMessages;

@RestController
@RequestMapping("/api/validation")
public class ValidationMessagesController {

    @GetMapping("/messages")
    @ResponseBody
    public ValidationMessages getValidationMessages() {
        return new ValidationMessages();
    }
}

package com.example.app.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {
    private String message;
    private String cause;
    private Map<String, String> validationMessages = new HashMap<>();

    public ErrorResponse(String message, String cause) {
        this.message = message;
        this.cause = cause;
    }

    public Map<String, String> getValidationMessages() {
        return validationMessages;
    }

    public void setValidationMessages(Map<String, String> validationMessages) {
        this.validationMessages = validationMessages;
    }

    public String getMessage() {
        return message;
    }

    public String getCause() {
        return cause;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}

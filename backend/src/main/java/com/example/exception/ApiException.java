package com.example.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private String message;
    private String cause;
    private HttpStatus status;

    public ApiException(String message, String cause, HttpStatus status) {
        super(message);
        this.message = message;
        this.cause = cause;
        this.status = status;
    }

    public ApiException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public String getCauseError() {
        return cause;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}

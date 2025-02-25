package com.example.app.utils;

public class ConstraintPatterns {
    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!()]).*$";
    public static final String NAME_PATTERN = "^[A-Za-zÁ-ÿ ]+$";
    public static final String PHONE_PATTERN = "^\\d{2}\\d{5}\\d{4}$";
}

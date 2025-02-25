package com.example.app.utils;

import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Documented
@Target({ ElementType.TYPE, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message = ValidationMessages.CONFIRM_PASSWORD_NO_MATCH;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

package com.example.user.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.user.model.User;

public class PasswordValidator implements ConstraintValidator<ValidPassword, User> {
    
    private static final Logger logger = LoggerFactory.getLogger(PasswordValidator.class);
    
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if (!user.getPassword().equals(user.getConfirmPassword()))
            logger.error("Validation error: As senhas não coincidem");  // Logando as mensagens de erro
        return user.getPassword().equals(user.getConfirmPassword());
    }
}

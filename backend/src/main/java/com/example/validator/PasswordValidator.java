package com.example.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.user.model.User;

public class PasswordValidator implements ConstraintValidator<ValidPassword, User> {

    private static final Logger logger = LoggerFactory.getLogger(PasswordValidator.class);

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        if (!user.getPassword().equals(user.getPassword()))
            logger.error(ValidationMessages.CONFIRM_PASSWORD_NO_MATCH);
        return user.getPassword().equals(user.getPassword());
    }
}

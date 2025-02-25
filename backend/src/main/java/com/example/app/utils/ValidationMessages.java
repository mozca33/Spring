package com.example.app.utils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationMessages {

    // Mensagens de validação
    public static final String USER_ALREADY_EXISTS = "O usuário já está registrado.";
    public static final String USER_NOT_FOUND = "O usuário não foi encontrado.";

    public static final String PASSWORD_NOT_BLANK = "A senha deve ser preenchida.";
    public static final String PASSWORD_TOO_SHORT = "A senha deve ter mais de 6 caracteres.";
    public static final String PASSWORD_CONSTRAINTS = "A senha deve ter ao menos:\n- Uma letra maiúscula\n- Um número\n-  Um caractere especial.";

    public static final String INVALID_CREDENTIALS = "As credenciais são inválidas.";

    public static final String CONFIRM_PASSWORD_NOT_BLANK = "A confirmação de senha não deve estar vazia.";
    public static final String CONFIRM_PASSWORD_NO_MATCH = "As senhas não coincidem.";

    public static final String NAME_NOT_BLANK = "O nome deve ser preenchido.";
    public static final String NAME_TOO_LONG = "O nome não pode ter mais de 200 caracteres.";
    public static final String NAME_CONSTRAINTS = "O nome não pode conter números ou caracteres especiais.";

    public static final String EMAIL_NOT_VALID = "O e-mail não é válido.";
    public static final String EMAIL_NOT_BLANK = "O e-mail deve ser preenchido.";

    public static final String DESCRIPTION_TOO_LONG = "A descrição pode conter até 500 caracteres.";

    public static final String PHONE_FORMAT = "O telefone deve estar no formato (XX) XXXX-XXXX.";
    public static final String BIRTH_DATE_NOT_BLANK = "A data de nascimento deve ser preenchida.";
    public static final String BIRTH_DATE_INVALID = "A data de nascimento é inválida.";

    // Métodos GET para cada mensagem

    @GetMapping("/user-already-exists")
    public String getUserAlreadyExists() {
        return USER_ALREADY_EXISTS;
    }

    @GetMapping("/user-not-found")
    public String getUserNotFound() {
        return USER_NOT_FOUND;
    }

    @GetMapping("/password-not-blank")
    public String getPasswordNotBlank() {
        return PASSWORD_NOT_BLANK;
    }

    @GetMapping("/password-too-short")
    public String getPasswordTooShort() {
        return PASSWORD_TOO_SHORT;
    }

    @GetMapping("/password-constraints")
    public String getPasswordConstraints() {
        return PASSWORD_CONSTRAINTS;
    }

    @GetMapping("/invalid-credentials")
    public String getInvalidCredentials() {
        return INVALID_CREDENTIALS;
    }

    @GetMapping("/confirm-password-not-blank")
    public String getConfirmPasswordNotBlank() {
        return CONFIRM_PASSWORD_NOT_BLANK;
    }

    @GetMapping("/confirm-password-no-match")
    public String getConfirmPasswordNoMatch() {
        return CONFIRM_PASSWORD_NO_MATCH;
    }

    @GetMapping("/name-not-blank")
    public String getNameNotBlank() {
        return NAME_NOT_BLANK;
    }

    @GetMapping("/name-too-long")
    public String getNameTooLong() {
        return NAME_TOO_LONG;
    }

    @GetMapping("/name-constraints")
    public String getNameConstraints() {
        return NAME_CONSTRAINTS;
    }

    @GetMapping("/email-not-valid")
    public String getEmailNotValid() {
        return EMAIL_NOT_VALID;
    }

    @GetMapping("/email-not-blank")
    public String getEmailNotBlank() {
        return EMAIL_NOT_BLANK;
    }

    @GetMapping("/description-too-long")
    public String getDescriptionTooLong() {
        return DESCRIPTION_TOO_LONG;
    }

    @GetMapping("/phone-format")
    public String getPhoneFormat() {
        return PHONE_FORMAT;
    }

    @GetMapping("/birth-date-not-blank")
    public String getBirthDateNotBlank() {
        return BIRTH_DATE_NOT_BLANK;
    }

    @GetMapping("/birth-date-invalid")
    public String getBirthDateInvalid() {
        return BIRTH_DATE_INVALID;
    }
}

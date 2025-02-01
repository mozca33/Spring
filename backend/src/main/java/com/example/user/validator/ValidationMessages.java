package com.example.user.validator;

public class ValidationMessages {
    /*
    public static final String message = "";
    */
    public static final String USER_ALREADY_EXISTS = "O usuário já está registrado.";

    public static final String NAME_NOT_BLANK = "O nome deve ser preenchido.";
    public static final String NAME_TOO_LONG = "O nome não pode ter mais de 200 caracteres.";
    public static final String NAME_CONSTRAINTS = "O nome não pode conter números ou caracteres especiais.";

    public static final String PASSWORD_NOT_BLANK = "A senha deve ser preenchida.";
    public static final String PASSWORD_TOO_SHORT = "A senha deve ter mais de 6 caracteres.";
    public static final String PASSWORD_CONSTRAINTS = "A senha deve ter ao menos uma letra maiúscula, um número e um caractere especial.";

    public static final String CONFIRM_PASSWORD_NOT_BLANK = "A confirmação de senha não deve estar vazia.";
    public static final String CONFIRM_PASSWORD_NO_MATCH = "As senhas não coincidem.";

    public static final String DESCRIPTION_TOO_LONG = "A descrição pode conter até 500 caracteres.";

    public static final String EMAIL_NOT_VALID = "O e-mail não é válido.";
    public static final String EMAIL_NOT_BLANK = "O e-mail deve ser preenchido.";
    
    public static final String PHONE_FORMAT = "O telefone deve estar no formato (XX) XXXX-XXXX.";
    public static final String BIRTH_DATE_NOT_BLANK = "A data de nascimento deve ser preenchida.";
    public static final String BIRTH_DATE_INVALID = "A data de nascimento é inválida";
}

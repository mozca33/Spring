import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserValidationService {
  constructor() {}

  public validateFieldsLogin(
    email: string,
    password: string,
    validationMessages: string[]
  ): boolean {
    let valid = true;

    if (!email) {
      validationMessages.push('O e-mail deve ser preenchido.');
      valid = false;
    } else if (!this.isValidEmail(email)) {
      validationMessages.push('O e-mail deve ser válido.');
      valid = false;
    }

    if (!password) {
      validationMessages.push('A senha deve ser preenchida.');
      valid = false;
    }

    return valid;
  }

  public validateFieldsRegister(
    name: string,
    email: string,
    birthDateFormat: Date,
    password: string,
    confirmPassword: string,
    validationMessages: string[]
  ): boolean {
    let valid = true;

    if (!name) {
      validationMessages.push('O nome deve ser preenchido.');
      valid = false;
    }

    if (!email) {
      validationMessages.push('O e-mail deve ser preenchido.');
      valid = false;
    } else if (!this.isValidEmail(email)) {
      validationMessages.push('O e-mail deve ser válido.');
      valid = false;
    }

    if (!password) {
      validationMessages.push('A senha deve ser preenchida.');
      valid = false;
    } else {
      validationMessages.push('A senha deve ter ao menos:<br/>');
      console.log(valid);
      if (password.length < 6) {
        validationMessages.push('- Mais de 6 caracteres.<br/>');
        valid = false;
      }
      if (!/[A-Z]/.test(password)) {
        validationMessages.push('- Uma letra maiúscula.<br/>');
        valid = false;
      }
      if (!/\d/.test(password)) {
        validationMessages.push('- Um número.<br/>');
        valid = false;
      }
      if (!/[!@#$%^&*(),.?":{}|<>]/.test(password)) {
        validationMessages.push('- Um caractere especial.<br/>');
        valid = false;
      }
    }

    // Verificar se as senhas coincidem
    if (password !== confirmPassword) {
      validationMessages.push('As senhas não coincidem.');
      valid = false;
    }

    // Validação da data (idade entre 16 e 100 anos)
    if (!this.isValidDate(birthDateFormat)) {
      validationMessages.push('A data de nascimento deve ser uma data válida.');
      valid = false;
    }
    console.log(valid);
    return valid;
  }

  private isValidEmail(email: string): boolean {
    const re = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return re.test(email);
  }

  // Função para validar a data de nascimento
  private isValidDate(date: Date): boolean {
    const now = new Date();
    const age = now.getFullYear() - date.getFullYear();
    const month = now.getMonth() - date.getMonth();
    const day = now.getDate() - date.getDate();

    // Se a idade for maior ou igual a 16 anos e menor que 100 anos
    return age >= 16 && age < 100;
  }
}

import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ModalService } from '../modal.service';
import { ApiService } from '../api/api-user.service';
import { UserValidationService } from '../user-validation/user-validation.service';

@Component({
  selector: 'app-register-modal',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './register-modal.component.html',
  styleUrl: './register-modal.component.css',
})
export class RegisterModalComponent {
  name: string = '';
  email: string = '';
  password: string = '';
  confirmPassword: string = '';
  birthDate: Date = new Date();
  birthDateFormat: Date = new Date();
  resultMessage: string = '';
  isSuccess: boolean = false;
  validationMessages: string[] = [];
  defaultValidationMessages = [
    'A senha deve ter ao menos:<br/>- Mais de 6 caracteres<br/>- Uma letra minúscula<br/>- Uma letra Maiúscula<br/>- Um número<br/>- Um caractere Especial',
  ];

  constructor(
    private apiService: ApiService,
    private userValidationService: UserValidationService,
    public modalService: ModalService
  ) {}

  public register() {
    this.resultMessage = '';
    this.validationMessages = [];
    this.birthDateFormat = new Date(this.birthDate);
    if (
      this.userValidationService.validateFieldsRegister(
        this.name,
        this.email,
        this.birthDateFormat,
        this.password,
        this.confirmPassword,
        this.validationMessages
      )
    ) {
      this.apiService
        .register(
          this.name,
          this.email,
          this.birthDate,
          this.password,
          this.confirmPassword
        )
        .subscribe({
          next: (response) => {
            this.resultMessage = response.message;
            this.isSuccess = response.success;
          },
        });
    } else {
      return;
    }
  }
}

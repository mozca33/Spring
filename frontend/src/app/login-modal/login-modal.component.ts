import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { ModalService } from '../modal.service';
import { ApiService } from '../api/api-user.service';
import { UserValidationService } from '../user-validation/user-validation.service';

@Component({
  selector: 'app-login-modal',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],
  templateUrl: './login-modal.component.html',
  styleUrl: './login-modal.component.css',
})
export class LoginModalComponent {
  constructor(
    private apiService: ApiService,
    private userValidationService: UserValidationService,
    public modalService: ModalService
  ) {}

  email: string = '';
  password: string = '';
  validationMessages: string[] = [];
  defaultValidationMessages = ['Credenciais inválidas'];

  login() {
    this.validationMessages = [];
    if (
      this.userValidationService.validateFieldsLogin(
        this.email,
        this.password,
        this.validationMessages
      )
    ) {
      const result = this.apiService.login(this.email, this.password);
      return result;
    } else {
      return this.validationMessages;
    }
  }
}

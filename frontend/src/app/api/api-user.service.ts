import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { ModalService } from '../modal.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  constructor(
    private http: HttpClient,
    private modalService: ModalService,
    private router: Router
  ) {}

  private apiRegisterURL = 'http://localhost:8080/api/user/register';
  private apiLoginURL = 'http://localhost:8080/api/user/login';

  login(email: String, password: String) {
    const loginData = {
      email: email,
      password: password,
    };

    console.log(this.apiLoginURL);

    this.http.post(this.apiLoginURL, loginData).subscribe({
      next: (response) => {
        alert('Login bem sucedido!');
        this.router.navigate(['/home']);
      },
    });
  }

  register(
    name: String,
    email: String,
    birthDate: Date,
    password: String,
    confirmPassword: String
  ): Observable<any> {
    const registerData = {
      name: name,
      email: email,
      password: password,
      confirmPassoword: confirmPassword,
      birthDate: birthDate,
    };
    console.log('aq');
    this.http.post(this.apiRegisterURL, registerData).subscribe({
      next: (response) => {
        console.log(
          'Registro efetuado com sucesso, confirme seu email.',
          response
        );
      },
      error: (err) => {
        alert('Error ocurred: ' + err.message);
      },
    });

    this.router.navigate(['/login']);

    return of(null);
  }
}

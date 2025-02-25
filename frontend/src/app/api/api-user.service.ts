import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, map, Observable, of } from 'rxjs';
import { ModalService } from '../modal.service';
import { Router } from '@angular/router';
import { RegisterModalComponent } from '../register-modal/register-modal.component';

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

  get<T>(url: string): Observable<T> {
    return this.http.get<T>(url);
  }

  post<T>(url: string, body: any): Observable<T> {
    return this.http.post<T>(url, body);
  }

  login(email: String, password: String) {
    const loginData = {
      email: email,
      password: password,
    };

    this.http.post(this.apiLoginURL, loginData).subscribe({
      next: (response) => {
        alert('Login bem sucedido!');
        this.modalService.closeLoginModal();
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
    return this.http.post(this.apiRegisterURL, registerData).pipe(
      map((response) => {
        return { success: true, message: 'Registro efetuado com sucesso!' };
      }),
      catchError((err) => {
        return of({ success: false, message: err.error.message });
      })
    );
  }
}

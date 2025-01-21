import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private apiUrl = 'https://localhost:8080/user'; // URL da API

  constructor(private http: HttpClient) {}

  getUserName(): Observable<{ name: string }> {
    return this.http.get<{ name: string }>(`${this.apiUrl}/profile`);
  }
}

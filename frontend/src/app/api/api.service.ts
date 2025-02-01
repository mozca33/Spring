import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private apiURL = 'http://localhost:8080/api/message';

  constructor(private http: HttpClient) {}
  obtainMessage(): Observable<String> {
    return this.http.get<String>(this.apiURL);
  }
}

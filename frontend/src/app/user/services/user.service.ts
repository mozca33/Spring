import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-user-form',
  templateUrl: '../user-form.component.html',
})
export class UserFormComponent {
  user = {
    name: '',
    description: '',
  };

  constructor(private http: HttpClient) {}

  saveUser() {
    this.http
      .post('http://localhost:8080/user', this.user)
      .subscribe((response) => {
        console.log('User saved successfully!', response);
      });
  }
}

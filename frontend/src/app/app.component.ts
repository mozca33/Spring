import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'App Project';
  description = 'Sobre mim';

  ngOnInit(): void {
    /*
    this.userService.getUserName().subscribe({
      next: (response) => {
        this.userName = response.name; // Nome retornado pelo backend
      },
      error: (error) => {
        console.error('Erro ao buscar o nome do usuário:', error);
      },
    });
     */
  }
}

import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ApiService } from './api/api.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {
  title = 'App Project';
  description = 'Sobre mim';
  mensagem!: String;

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.apiService.obtainMessage().subscribe({
      next: (data: String) => (this.mensagem = data),
      error: (error) => console.error('Erro ao buscar mensagem', error),
    });
  }
}

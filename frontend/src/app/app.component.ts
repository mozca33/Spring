import { Component, OnInit } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ModalService } from './modal.service';
import { RegisterModalComponent } from './register-modal/register-modal.component';
import { LoginModalComponent } from './login-modal/login-modal.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    CommonModule,
    RouterModule,
    FormsModule,
    LoginModalComponent,
    RegisterModalComponent,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent implements OnInit {
  constructor(public modalService: ModalService) {}

  title = 'Cardify';

  links = [
    {
      title: 'Github',
      link: 'https://github.com/mozca33/Spring',
      src: '/app/assets/github-icon.svg',
    },
    {
      title: 'LinkedIn',
      link: 'https://www.linkedin.com/in/rafael-f-cordeiro-1a2744214',
      src: '/app/assets/linkedin-icon.svg',
    },
    {
      title: 'Instagram',
      link: 'https://www.instagram.com/rafaelf.c/',
      src: '/app/assets/instagram-icon.svg',
    },
  ];

  ngOnInit() {}
}

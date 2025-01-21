import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  title = 'Home';
  description = 'Sobre mim';
  constructor(private router: Router) {}
  projects: any[] = [];

  ngOnInit(): void {
    this.router.navigate(['/']);
  }
}

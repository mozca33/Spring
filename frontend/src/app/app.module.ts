import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutes } from './app.routes';
import { bootstrapApplication } from '@angular/platform-browser';

@NgModule({
  imports: [BrowserModule, AppRoutes],
})
export class AppModule {}

bootstrapApplication(AppComponent);

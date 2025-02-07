import { AppComponent } from './app.component';
import { routes } from './app.routes';
import { bootstrapApplication, BrowserModule } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';
import { provideRouter, RouterModule } from '@angular/router';

bootstrapApplication(AppComponent, {
  providers: [provideRouter(routes), provideHttpClient()],
});

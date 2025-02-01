import { AppComponent } from './app.component';
import { AppRoutes } from './app.routes';
import { bootstrapApplication } from '@angular/platform-browser';
import { provideHttpClient } from '@angular/common/http';

bootstrapApplication(AppComponent, {
  providers: [provideHttpClient(), AppRoutes],
});

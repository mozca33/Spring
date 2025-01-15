import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { AppComponent } from './app/app.component';
import { ProjectListComponent } from './app/project-list/project-list.component';

bootstrapApplication(ProjectListComponent, appConfig).catch((err) =>
  console.error(err)
);

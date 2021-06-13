import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MenuModule } from 'primeng/menu';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { NavigationComponent } from './navigation/navigation.component';
import { HomeComponent } from './home/home.component';
import { LoginGuard } from './login.guard';
import { MyStatisticsComponent } from './my-statistics/my-statistics.component';
import { EnterStepsComponent } from './enter-steps/enter-steps.component';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';


providers: [LoginGuard];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavigationComponent,
    HomeComponent,
    MyStatisticsComponent,
    EnterStepsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MenuModule,
    BrowserAnimationsModule,
    ButtonModule,
    TableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

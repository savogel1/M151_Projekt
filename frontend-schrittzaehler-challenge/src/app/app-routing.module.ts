import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddGroupComponent } from './add-group/add-group.component';
import { EnterStepsComponent } from './enter-steps/enter-steps.component';
import { HomeComponent } from './home/home.component';
import { LoginGuard } from './login.guard';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MyStatisticsComponent } from './my-statistics/my-statistics.component';
import { RoleGuard } from './role.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate:[LoginGuard]
  }
  ,
  {
    path: 'my-statistics',
    component: MyStatisticsComponent,
    canActivate:[LoginGuard]
  }
  ,
  {
    path: 'enter-steps',
    component: EnterStepsComponent,
    canActivate:[LoginGuard]
  }
  ,
  {
    path: 'logout',
    component: LogoutComponent,
    canActivate:[LoginGuard],
  }
  ,
  {
    path: 'add-group',
    component: AddGroupComponent,
    canActivate:[RoleGuard], 
    data: { 
      expectedRole: 'admin'
    }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

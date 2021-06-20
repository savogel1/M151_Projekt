import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username: string = '';
  password: string = '';

  constructor(private service : AuthService, private routes: Router) { }
  
  ngOnInit() { }
  
  login() {
    this.service.login(this.username, this.password)
      .pipe(first()).subscribe({
      next: () => {
        console.log('successful login')
        this.routes.navigate(['/home']);
      },
      error: error => {
        alert('Username and/or Password are not correct')
        console.log('Error ' + error);
      }
    })
  }
}

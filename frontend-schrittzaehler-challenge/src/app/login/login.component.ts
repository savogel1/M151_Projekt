import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MyserviceService } from '../service/myservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  msg: any;

  constructor(private service : MyserviceService , private routes: Router) { }
  
  ngOnInit() { }

  check(username: string, password: string)
  {
    var output = this.service.checkusernameandpassword(username, password);
    if(output == true) {
      this.routes.navigate(['/home']);
    } else {
      this.msg ='Invalid username or password';
    }
  }
}

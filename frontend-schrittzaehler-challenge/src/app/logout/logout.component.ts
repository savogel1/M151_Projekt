import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router, private service : AuthService) { }

  ngOnInit(): void {
    this.service.logout();
  }

  navigate(url: string) {
    this.router.navigateByUrl(`/${url}`);
  }

}

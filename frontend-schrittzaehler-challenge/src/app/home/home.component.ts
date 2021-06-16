import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Group } from 'src/model/Group';
import { User } from 'src/model/User';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  groups: Group[] = [
    {
      id: 1,
      rank: 1,
      name: 'testGroup 1',
      totalSteps: 350000,
      averageSteps: 42600,
    },
    {
      id: 2,
      rank: 2,
      name: 'testGroup 2',
      totalSteps: 250000,
      averageSteps: 34000,
    },
  ];

  users: User[] = [];

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  navigate(url: string) {
    this.router.navigateByUrl(`/${url}`);
  }

  async loadUsers(): Promise<void> {
    this.users = await this.userService.getAllUsers();
  }
}

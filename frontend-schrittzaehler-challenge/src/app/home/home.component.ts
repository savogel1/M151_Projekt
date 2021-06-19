import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Group } from 'src/model/Group';
import { User } from 'src/model/User';
import { GroupService } from '../service/group.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  groups: Group[] = [];
  users: User[] = [];

  constructor(private userService: UserService, private groupService: GroupService, private router: Router) {}

  ngOnInit(): void {
    this.loadGroups();
    this.loadUsers();
  }

  navigate(url: string) {
    this.router.navigateByUrl(`/${url}`);
  }

  async loadUsers(): Promise<void> {
    this.users = await this.userService.getAllUsers();
  }

  async loadGroups(): Promise<void> {
    this.groups = await this.groupService.getAllGroups();
  }
}

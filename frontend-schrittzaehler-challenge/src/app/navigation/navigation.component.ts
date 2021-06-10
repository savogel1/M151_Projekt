import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {MenuItem} from 'primeng/api';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  items: MenuItem[];

  constructor(private router: Router) {
    this.items = [];
  }

  ngOnInit() {
    this.items = [{
      label: 'Menu',
      items: [{
          label: 'Home',
          icon: 'pi pi-home',
          command: () => {
              this.navigate('home');
          }
      },
      {
          label: 'My Statistics',
          icon: 'pi pi-chart-bar',
          command: () => {
              this.navigate('my-statistics');
          }
      },{
          label: 'Enter Steps',
          icon: 'pi pi-user-plus',
          command: () => {
              this.navigate('enter-steps');
          }
      }]
    }];
  }


  navigate(url: string) {
    this.router.navigateByUrl(`/${url}`)
  }
}
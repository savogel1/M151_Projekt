import { Component, OnInit } from '@angular/core';
import { Group } from 'src/model/Group';

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

  constructor() {}

  ngOnInit(): void {}
}

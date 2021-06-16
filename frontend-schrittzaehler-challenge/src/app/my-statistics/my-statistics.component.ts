import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-statistics',
  templateUrl: './my-statistics.component.html',
  styleUrls: ['./my-statistics.component.css'],
})
export class MyStatisticsComponent implements OnInit {
  stepData: any;
  options: any;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.stepData = {
      labels: [
        '10.06.2021',
        '11.06.2021',
        '12.06.2021',
        '13.06.2021',
        '14.06.2021',
        '15.06.2021',
      ],
      datasets: [
        {
          label: 'Meine Schritte',
          backgroundColor: '#42A5F5',
          data: [5900, 8056, 8461, 5687, 5565, 0],
        },
      ],
    };
    this.options = {
      title: {
        display: true,
        text: 'Meine Schritte',
        fontSize: 16,
      },
      legend: {
        position: 'bottom',
      },
    };
  }

  navigate(url: string) {
    this.router.navigateByUrl(`/${url}`);
  }
}

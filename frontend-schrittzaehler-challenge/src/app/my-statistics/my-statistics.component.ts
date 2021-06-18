import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Step } from 'src/model/Step';
import { StepService } from '../service/step.service';

@Component({
  selector: 'app-my-statistics',
  templateUrl: './my-statistics.component.html',
  styleUrls: ['./my-statistics.component.css'],
})
export class MyStatisticsComponent implements OnInit {
  stepChart: any;
  stepChartOptions: any;
  steps: Step[] = [];
  concatenatedSteps: {creationDate: string, numberOfSteps: number}[] = []; 

  constructor(private stepService: StepService, private router: Router) {}

  async ngOnInit(): Promise<void> {
    this.steps = await this.stepService.getStepsByUser(1);

    this.steps.forEach((step) => {
      if (this.isDateExisting(step)) {
        this.concatenatedSteps.forEach(concatenatedStep => {
          if (step.creationDate === concatenatedStep.creationDate) {
            concatenatedStep.numberOfSteps += step.numberOfSteps;
          }
        });
      } else {
        this.concatenatedSteps.push({creationDate: step.creationDate, numberOfSteps: step.numberOfSteps});
      }
    });

    this.stepChart = {
      labels: this.concatenatedSteps.map(step => step.creationDate),
      datasets: [
        {
          label: 'Meine Schritte',
          backgroundColor: '#42A5F5',
          data: this.concatenatedSteps.map(step => step.numberOfSteps),
        },
      ],
    };
    this.stepChartOptions = {
      responsive: true,
      scales: {
        yAxes: [
          {
            ticks: {
              beginAtZero: true,
            },
          },
        ],
      },
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
  isDateExisting(step: Step): boolean {
    return (this.concatenatedSteps.filter(concatenatedStep => concatenatedStep.creationDate === step.creationDate).length > 0);
  }

  async loadStepsByUser(): Promise<Step[]> {
    return this.steps;
  }

  navigate(url: string) {
    this.router.navigateByUrl(`/${url}`);
  }
}

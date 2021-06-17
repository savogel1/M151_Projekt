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
  stepData: any;
  options: any;
  steps: Step[] = [];

  constructor(private stepService: StepService, private router: Router) {}

  async ngOnInit(): Promise<void> {
    this.steps = await this.stepService.getStepsByUser(1);
    let numberOfSteps: number[] = [];
    let creationDates: string[] = [];
    this.steps.forEach(step => {
      numberOfSteps.push(step.numberOfSteps);
      creationDates.push(step.creationDate);
    });

    this.stepData = {
      labels: creationDates,
      datasets: [
        {
          label: 'Meine Schritte',
          backgroundColor: '#42A5F5',
          data: numberOfSteps,
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

  async loadStepsByUser(): Promise<Step[]> {
    
    return this.steps;
  }

  navigate(url: string) {
    this.router.navigateByUrl(`/${url}`);
  }
}

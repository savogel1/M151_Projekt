import { Component, OnInit } from '@angular/core';
import { EnterStepsService } from '../service/enter-steps.service';
import { formatDate } from '@angular/common';
import { Inject } from '@angular/core';
import { LOCALE_ID } from '@angular/core';

@Component({
  selector: 'app-enter-steps',
  templateUrl: './enter-steps.component.html',
  styleUrls: ['./enter-steps.component.css']
})
export class EnterStepsComponent implements OnInit {
  date: Date;
  numberOfSteps!: number;

  constructor(private enterStepsService: EnterStepsService, @Inject(LOCALE_ID) private locale: string) { 
    this.date = new Date();
  }

  ngOnInit(): void {

  }

  save(): void {
    if (this.numberOfSteps != null && this.date != null) {
      this.enterStepsService.createStepForCurrentUser(this.numberOfSteps, formatDate(this.date, 'yyyy-MM-dd', this.locale));
    } else {
      alert("Steps or date may not be empty!");
    }
  }

}

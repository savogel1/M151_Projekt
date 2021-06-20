import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Step } from 'src/model/Step';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class EnterStepsService {

  constructor(private http: HttpClient, private router: Router, private authService: AuthService) { }

  async createStepForCurrentUser(numberOfSteps: number, date: string): Promise<void> {
    var step: Step = {
      id: 1, 
      userId: this.authService.currentUserValue.id,
      numberOfSteps: numberOfSteps,
      creationDate: date
    };
    
    try {
      await this.http.post(`http://localhost:8080/step/add`, step).toPromise();
      alert(`Successfully added steps to user with id: ${step.userId}`)
      this.router.navigateByUrl('/home');
    } catch (e) {
      Promise.reject();
    }
  }
}

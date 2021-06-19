import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Step } from 'src/model/Step';

@Injectable({
  providedIn: 'root'
})
export class EnterStepsService {

  constructor(private http: HttpClient) { }

  async createStepForCurrentUser(numberOfSteps: number, date: string): Promise<void> {
    var step: Step = {
      id: 1, 
      userId: 1,
      numberOfSteps: numberOfSteps,
      creationDate: date
    };
    
    try {
      await this.http.post(`http://localhost:8080/step/add`, step).toPromise();
      alert(`Successfully added steps to user with id: ${step.userId}`)
    } catch (e) {
      Promise.reject();
    }
  }
}

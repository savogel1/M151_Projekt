import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AppSettings } from 'src/app-settings';
import { Step } from 'src/model/Step';

@Injectable({
  providedIn: 'root'
})
export class StepService {

  constructor(private http: HttpClient) { }

  async getStepsByUser(userid: number): Promise<Step[]> {
    try {
      return await this.http.get<Step[]>(`http://localhost:8080/step/by-user/${userid}`).toPromise();
    } catch (e) {
      return Promise.reject();
    }
  }
}

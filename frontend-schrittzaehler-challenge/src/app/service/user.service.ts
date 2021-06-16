import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from 'src/model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  async getAllUsers(): Promise<User[]> {
    try {
      return this.http.get<User[]>('http://localhost:8080/user/').toPromise();
    } catch (error) {
      return Promise.reject();
    }
  }
}

import { Injectable } from '@angular/core';
import { Group } from 'src/model/Group';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GroupService {

  constructor(private http: HttpClient) { }

  async getAllGroups(): Promise<Group[]> {
    try {
      return this.http.get<Group[]>('http://localhost:8080/group/').toPromise();
    } catch (e) {
      return Promise.reject();
    }
  }
}

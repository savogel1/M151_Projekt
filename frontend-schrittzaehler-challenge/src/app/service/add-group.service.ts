import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Group } from 'src/model/Group';

@Injectable({
  providedIn: 'root'
})
export class AddGroupService {

  constructor(private http: HttpClient, private router: Router) { }

  async createGroup(groupname: string): Promise<void> {   
    var group: Group = {
      id: 1, 
      competitionId: 1,
      groupname: groupname,
      totalSteps: 0,
      averageSteps: 0,
    };
    
    try {
      await this.http.post(`http://localhost:8080/group/add`, group).toPromise();
      alert(`Successfully added steps to group with name: ${group.groupname}`)
      this.router.navigateByUrl('/home');
    } catch (e) {
      Promise.reject();
    }
  }
}

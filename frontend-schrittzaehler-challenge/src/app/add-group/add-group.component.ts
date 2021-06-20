import { Component, OnInit } from '@angular/core';
import { AddGroupService } from '../service/add-group.service';

@Component({
  selector: 'app-add-group',
  templateUrl: './add-group.component.html',
  styleUrls: ['./add-group.component.css']
})
export class AddGroupComponent implements OnInit {
  groupname!: string;

  constructor(private addGroupService: AddGroupService) { }

  ngOnInit(): void {
  }

  save(): void {
    if (this.groupname != null) {
      this.addGroupService.createGroup(this.groupname);
    } else {
      alert("Steps may not be empty!");
    }
  }
}

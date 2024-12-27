import { Component, OnInit } from '@angular/core';

import { HttpService } from '../http.service';

import { notes } from '../Model/Notes';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-add-notes',
  templateUrl: './add-notes.component.html',
  styleUrls: ['./add-notes.component.css'],
})
export class AddNotesComponent implements OnInit {
  num: any;
  isUpdated: boolean = false;
  addData: notes = {
    title: '',
    content: '',
    createdDate:new Date(),
    updatedDate:new Date(),
    user: {
      id: 0,
      name:'',
      email:'',
      age:0
    },
    nid: 0,
  };

  constructor(
    private service: HttpService,
    private router: Router,
    private rout: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.getDataFromURL();

    let num = localStorage.getItem('id');
    this.num = num;
  }

  onSubmit() {
    if (this.isUpdated) {
      this.service.updateNotesData(this.addData).subscribe((response: any) => {
      

        this.router.navigate(['/details']);
      });
    }

    console.log(this.addData);
    console.log(this.num + 'bhushan');
    this.addData.user.id = this.num;
    this.service.postMapping(this.addData).subscribe((response: any) => {
      // console.log(response);
      alert('Inserted Successfully....');
      this.router.navigate(['/details']);
    });
  }

  getDataFromURL() {
    this.rout.paramMap.subscribe((param) => {
      // console.log('Inserted Successfully....');
      this.isUpdated = true;

      this.getNotesByIdFromBackednd(param.get('id'));
    });
  }

  getNotesByIdFromBackednd(id: any) {
    this.service.getNotesById(id).subscribe((response: any) => {
      // console.log(response);
      this.addData = response;
    });
  }
}

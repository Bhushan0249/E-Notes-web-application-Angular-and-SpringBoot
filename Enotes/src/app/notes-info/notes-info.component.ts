import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpService } from '../http.service';
import { notes } from '../Model/Notes';

@Component({
  selector: 'app-notes-info',
  templateUrl: './notes-info.component.html',
  styleUrls: ['./notes-info.component.css'],
})
export class NotesInfoComponent implements OnInit {
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
  }

  getDataFromURL() {
    this.rout.paramMap.subscribe((param) => {
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

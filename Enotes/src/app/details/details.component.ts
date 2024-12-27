import { Component, OnInit } from '@angular/core';
import { HttpService } from '../http.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css'],
})
export class DetailsComponent implements OnInit {
  constructor(private service: HttpService, private router: Router,private route :ActivatedRoute) {}

  ngOnInit(): void {
    this.getDataFromBackand();
  }

  empData: any[] = [];

  id!: any;
  getDataFromBackand() {
    this.id = localStorage.getItem('id');
    this.service.getAllNotes(this.id).subscribe((response: any) => {
      // console.log(response)
      this.empData = response;
    });
  }

  onUpdate(ans: any) {
    this.router.navigate(['/updateNotes', ans]);
  }

  onDeleted(nid: any) {
    // console.log(nid)
    this.service.deleteData(nid).subscribe((response: any) => {
      // console.log(response);
     
      alert(response);
      this.router.navigate(['/addNotes']);
    });
  }

  aboutIfo(id:any){

    this.router.navigate(['/NotesInfo', id]);


  }


}

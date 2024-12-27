import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpService } from '../http.service';
import { User } from '../Model/User';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent {

  addData = {
    name: '',
    email: '',
    password:'',
    age:null
  };


  constructor(private service:HttpService,
    private router:Router,
    private route :ActivatedRoute
  ){}

  onSubmit(){

    // console.log(this.addData);

    this.service.addUser(this.addData).subscribe((response:any)=>{
  

      console.log(response);
      alert(response);
      this.router.navigate(['']);
      
    });

  }

}

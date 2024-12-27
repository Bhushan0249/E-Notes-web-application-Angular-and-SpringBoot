import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent {
  credentials = {
    email: '',
    password: '',
  };

  constructor(private http: HttpClient, private router: Router) {}

  login() {
    this.http
      .post('http://localhost:8080/api/login', this.credentials)
      .subscribe((response: any) => {
        localStorage.setItem('id', response.id); // Store logged-in user ID
        console.log(response.id);

        alert('Login successful!');
        this.router.navigate(['/details']); // Redirect to Add Notes page

        // alert('due to some error..');
        // this.router.navigate(['']);
      });
  }
}

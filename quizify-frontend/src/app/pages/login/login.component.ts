import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  hide = true;
  constructor() {}

  credentials = {
    username: '',
    password: '',
  };

  ngOnInit(): void {}

  loginUser() {
    console.log(this.credentials.username);
    console.log(this.credentials.password);
  }
}

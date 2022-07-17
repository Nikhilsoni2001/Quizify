import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  hide = true;
  public user = {
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
  };
  constructor(private userService: UserService) {}

  ngOnInit(): void {}

  formSubmit() {
    if (this.user.username === null || this.user.username === '') {
      alert('User is required');
      return;
    }

    this.userService.addUser(this.user).subscribe(
      (data) => {
        console.log(data);
        alert('success');
      },
      (error) => {
        console.error(error);
        alert('failed');
      }
    );
  }
}

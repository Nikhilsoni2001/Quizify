import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
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
  constructor(
    private userService: UserService,
    private snackbar: MatSnackBar
  ) {}

  ngOnInit(): void {}

  formSubmit() {
    if (this.user.username === null || this.user.username === '') {
      this.snackbar.open('Username is required !!', 'Cancel', {
        duration: 3000,
      });
      return;
    }

    this.userService.addUser(this.user).subscribe({
      next: (res) => {
        console.log(res);
      },
      error: (err) => {
        console.log(err);

        this.snackbar.open('Something went wrong !!' + err.message, 'Cancel', {
          duration: 3000,
        });
      },
    });
  }
}

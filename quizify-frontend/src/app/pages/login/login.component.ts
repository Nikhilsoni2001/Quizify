import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  hide = true;
  constructor(
    private snackBar: MatSnackBar,
    private loginService: LoginService,
    private route: Router
  ) {}

  credentials = {
    username: '',
    password: '',
  };

  ngOnInit(): void {}

  loginUser() {
    if (
      this.credentials.username.trim() === '' ||
      this.credentials.username === null
    ) {
      this.snackBar.open('Invalid username!!', 'Cancel', {
        duration: 3000,
      });
      return;
    }

    if (
      this.credentials.password.trim() === '' ||
      this.credentials.password === null
    ) {
      this.snackBar.open('Invalid password!!', 'Cancel', {
        duration: 3000,
      });
      return;
    }

    this.loginService.generateToken(this.credentials).subscribe({
      next: (res: any) => {
        this.loginService.loginUser(res.token);
        this.loginService.getCurrentUser().subscribe({
          next: (user: any) => {
            this.loginService.setUser(user);

            if (this.loginService.getUserRole() === 'ADMIN') {
              this.route.navigate(['admin']);
              this.loginService.loginStatusSubject.next(true);
            } else if (this.loginService.getUserRole() === 'NORMAL') {
              this.route.navigate(['user-dashboard']);
              this.loginService.loginStatusSubject.next(true);
            } else {
              this.loginService.logout();
            }
          },
        });
      },
      error: (err) => {
        console.error(err);
        this.snackBar.open('Invalid Details !! Try again', 'Cancel', {
          duration: 3000,
        });
      },
    });
  }
}

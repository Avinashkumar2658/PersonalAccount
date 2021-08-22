import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';


@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})
export class LoginComponentComponent implements OnInit {

  invalidCreditials: boolean;
  invalidData: boolean;
  username: string = '';
  user_password: string = '';
  constructor(private basicAuthService: BasicAuthService, private router: Router) {
    this.invalidCreditials = false;
    this.invalidData = false;
  }

  ngOnInit() {
  }
       
  signIn() {
    if (this.username.trim().length === 0 || this.user_password.trim().length === 0) {
      this.invalidData = true;
      this.invalidCreditials = false;
      return;
    }
    this.basicAuthService.executeAuthencationService(this.username, this.user_password).subscribe(
      data => {
        this.basicAuthService.setAccountPageId('home');
      },
      error => {
        this.invalidData = false;
        this.invalidCreditials = true;
      }
    )
  }

  register() {
    this.basicAuthService.setAccountPageId('register');
  }

  forget_password() {
    this.basicAuthService.setAccountPageId('forget_password');
  }
  
}
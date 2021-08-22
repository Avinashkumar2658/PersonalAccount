import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/data/user.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {
  
  emailId: string = '';
  message:String;
  err:String;
  foo:number;
  spinner_status :number = 0;
  constructor(
      private router: Router,
      private basicAuthService: BasicAuthService,
      private userService : UserService
    
  ) {
      
   }

  ngOnInit() {
     
  }

  forgotPassword(forgetPassword) {
    this.foo = 0
    this.spinner_status = 1;
    this.userService.executeForgotPassword(this.emailId).subscribe(
     () => {
         this.foo = 1;
         this.spinner_status = 0;
         forgetPassword.reset();
         this.message="Request to reset password received. Check your inbox for the reset link."
      },
      error => {
          this.spinner_status = 0;
          this.foo = 2;
          forgetPassword.reset();
          this.err = "This email does not exist!"
        }
    );
  }

  cancel() {
    this.basicAuthService.setAccountPageId('login');
  }


}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/service/data/user.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {
  val: string;
  enrollmentNo: string;
  document: Document
  user_password: String;
  message:String;
  userId : String;
  foo: number = 4;
  new_password : String
  spinner_status: number = 1;
  stringPattern : String;
  constructor(private activatedRoute: ActivatedRoute, public basicAuth : BasicAuthService,
    private router : Router, private userService : UserService) { 
      this.val = this.activatedRoute.snapshot.url[0].path;
      this.enrollmentNo = this.activatedRoute.snapshot.url[1].path;
      this.stringPattern = this.activatedRoute.snapshot.url[2].path;
      this.userId = this.activatedRoute.snapshot.url[3].path;
      if(this.val == 'reset-password') {
        basicAuth.setAccountPageId('reset-password')
      }
      else {
        basicAuth.setAccountPageId('home')
      }
      this.linkverify();
  }

  ngOnInit(): void { 
    
  }
  executeResetPassword(passwordReset) {
    this.spinner_status = 0;
    if(!(this.user_password == this.new_password))
    {
      this.spinner_status = 1;
      alert("          password not match");
      passwordReset.reset();
      return;
    }
    this.userService.executeUpdatePassword(this.userId, this.user_password).subscribe(
    ()  => {
      this.foo = 2;
      this.spinner_status = 1;
      this.message= "Password successfully reset. You can now log in with the new credentials."
      },
      _error => {
        this.foo = 3;
        this.spinner_status = 1;
        this.message= "The link is invalid or broken!"
      }
    )
  }
  linkverify() {
    this.userService.executeFindUsercredential(this.userId, this.stringPattern).subscribe(
     (res) => {
      this.foo = res;
     }
     )
  }
  login() {
    this.basicAuth.setAccountPageId('login');
    window.history.pushState({}, document.title, "/" + "#");
  }
}

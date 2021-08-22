import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from 'src/app/service/data/user.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
import { LoginComponentComponent } from '../login-component/login-component.component';


export class User {
  constructor(
    public userId: number,
    public userName: String,
    public password: String,
    public recoveryEmail: String,
    public name: String,
    public address: String,
    public mobileNo: number,
    public isAdmin: boolean,
    public profile_photo : File,
    public amount: number
  ) { }
  public getUserId(): number {
    return this.userId;
  }
  public getUserName(): String {
    return this.userName;
  }
  public getPassword(): String {
    return this.password;
  }
  public getName(): String {
    return this.name;
  }
  public getAddress(): String {
    return this.address;
  }
  public getMobileNumber(): number {
    return this.mobileNo;
  }
  public getRecoveryEmail(): String {
    return this.recoveryEmail;
  }
  public getIsAdmin(): Boolean {
    return this.isAdmin;
  }
  public getProfilePhoto(): File {
    return this.profile_photo;
  }
  public getAmount(): number {
    return this.amount;
  }
}
@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  user: User;
  userId : number;
  message: String;
  spinner_status : number = 0;
  constructor(private userService: UserService, private router: Router, private basicAuthService: BasicAuthService
    ,private route: ActivatedRoute ) 
  {
    this.user = new User(0, '', '', '', '', '', null, true, null, 0);
    this.userId = this.route.snapshot.params['userId'];
   }

  ngOnInit(): void {
  }

  saveUser(registration) {
    this.spinner_status = 1;
    if(this.userId != 0 ) {
    this.userService.executeSaveUser(this.user).subscribe(
      () => {
        this.spinner_status = 0;
        this.message = 'Registration Successful';
        registration.reset();
        this.basicAuthService.setAccountPageId('login');
      },
      _error => {
       if(_error.status == 302)
       {
        this.spinner_status = 0;
         alert(" user name is already registered")
         
       }
       else if(_error.status == 417)
       {
        this.spinner_status = 0;
          alert("email Id is already registered")
          
       }
      });
    }
  }
  cancelUser() {
    this.basicAuthService.setAccountPageId('login');
  }
}

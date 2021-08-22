import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/data/user.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
import { User } from '../user-registration/user-registration.component';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
user: User
userId : number;
message: String;
spinner_status : number= 0;
constructor(private userService : UserService, private basicAuthService: BasicAuthService) { 
  this.user = new User(0, '', '', '', '', '', 0, true, null, 0);
}

ngOnInit(): void {
  this.executegetUserDetail();
}


executegetUserDetail() {
      this.userService.executeFindUserByuserId(this.basicAuthService.getAccountAuthenticatedUserId()).subscribe(
       (res) =>  {
            this.user = res;
        }
      )
}

executeUpdateUser(updateUserForm) {
  this.spinner_status = 1;
  this.userService.executeUpdateUser(this.user).subscribe(
    () =>  {
      this.spinner_status = 0;
      this.message = 'Successful update';
      updateUserForm.reset();
     },
     _error => {
      if(_error.status == 417)
      {
       this.spinner_status = 0;
       alert("email Id is already registered")   
      }
     }
   );
}


}

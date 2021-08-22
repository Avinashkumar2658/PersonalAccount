import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from './service/data/user.service';
import { BasicAuthService } from './service/http/basic-auth.service';



@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None
})

export class AppComponent implements OnInit{
  title = 'myaccount';
 

  constructor(public basicAuthService: BasicAuthService) {
   }

   ngOnInit() {}
 
}



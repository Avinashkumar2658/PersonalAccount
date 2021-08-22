import { Component, OnInit } from '@angular/core';
import { Subject, Subscription } from 'rxjs';
import { BankBookService } from 'src/app/service/data/bank-book.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
import { Incomed } from '../day-book/day-book.component';

@Component({
  selector: 'app-bank-book',
  templateUrl: './bank-book.component.html',
  styleUrls: ['./bank-book.component.css']
})
export class BankBookComponent implements OnInit {
  from :Date;
  to : Date;
  details: Incomed[] = [] ;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  subscription: Subscription;
  content :String;
  content2 : String;
  closingBalance : number;

  constructor(
    private service:BankBookService,
    private basicAuthService : BasicAuthService
  ) { }

  ngOnInit(): void {
    this.executeFindNetAmount();
  }
  
  headers = ['S NO.', 'Date', 'Amount', 'Pay/receive']
  findAllBankTransaction(from, to) {
    this.service.executeFindAllBankTransactionBetweenDate(this.basicAuthService.getAccountAuthenticatedUserId(), from, to).subscribe(
      (response : any) => {
        this.details = response;
        console.log(this.details);
        this.dtTrigger.next();
      }
    );
  }

  executeFindNetAmount() {
    this.service.executeFindNetAmount(this.basicAuthService.getAccountAuthenticatedUserId()).subscribe(
      (response : number) => {
        this.closingBalance = response;
      }
    )
  }

}

import { Component, OnInit } from '@angular/core';
import { Subject, Subscription } from 'rxjs';
import { CashBookService } from 'src/app/service/data/cash-book.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
import { Incomed } from '../day-book/day-book.component';

@Component({
  selector: 'app-cash-book',
  templateUrl: './cash-book.component.html',
  styleUrls: ['./cash-book.component.css']
})
export class CashBookComponent implements OnInit {
  from :Date;
  to : Date;
  details: Incomed[] = [] ;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  subscription: Subscription;
  content :String;
  content2 : String;
 closingBalance : number;

  constructor(private service:CashBookService,
    private basicAuthService : BasicAuthService) { }


    ngOnInit(): void {
      this.executeFindNetAmount();
    }


  headers = ['S NO.', 'Date', 'Amount', 'Pay/receive']
  


findAllCashTransaction(from, to) {
  this.service.executeFindAllCashTransactionBetweenDate(this.basicAuthService.getAccountAuthenticatedUserId(), from, to).subscribe(
    (response : any) => {
      this.details = response;
      console.log(this.details);
      this.dtTrigger.next();
    }
  );
}

executeFindNetAmount() {
  this.service.executeFindNetAmount(this.basicAuthService.getAccountAuthenticatedUserId()).subscribe(
    (response : any) => {
      this.closingBalance = response;
    }
  );
}

  

}

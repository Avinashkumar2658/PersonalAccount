import { Component, OnInit } from '@angular/core';
import { BalanceSheetService } from 'src/app/service/data/balance-sheet.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
@Component({
  selector: 'app-balance-sheet',
  templateUrl: './balance-sheet.component.html',
  styleUrls: ['./balance-sheet.component.css']
})
export class BalanceSheetComponent implements OnInit {
name:string;
from : Date;
to : Date;
details : any[];
grossProfit :number
  constructor(
    private basicAuthService : BasicAuthService, private balanceSheetService : BalanceSheetService
  ) { }
headers = ['Incomes', 'Amount'];
headers_exp = ['Expenses', 'Amount']
executeFindBalanceSheet(from, to) {
  this.balanceSheetService.executeFindBalanceSheetBetweenDate(this.basicAuthService.getAccountAuthenticatedUserId(), from, to).subscribe(
    (response : any) => {
      this.details = response;
     this.grossProfit = this.details[2]- this.details[3];
    }
  )
}
  ngOnInit(): void {
  }

}

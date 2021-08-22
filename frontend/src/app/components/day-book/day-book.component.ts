import { Component, OnInit } from '@angular/core';
import { Subject, Subscription } from 'rxjs';
import { DayBookService } from 'src/app/service/data/day-book.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
import { ExpenseCategories } from 'src/app/table/expense-cat-table/expense-cat-table.component';


export class Incomed {
  constructor(
    public incomeId: number,
    public incomeAccount: string,
    public incomeCategory: ExpenseCategories,
    public amount: number,
    public transDate: Date,
    public receiveMode: string,
    public remark: string,
    public userId: number
  ) { }

  public getIncomeId(): number {
    return this.incomeId;
  }
  public getIncomeAccount(): string {
    return this.incomeAccount;
  }

  public getIncomeCategory(): ExpenseCategories {
    return this.incomeCategory;
  }

  public getAmount(): number {
    return this.amount;
  }

  public getTansDate(): Date {
    return this.transDate;
  }

  public getReceiveMode(): string {
    return this.receiveMode;
  }

  public getRemark(): string {
    return this.remark;
  }
  public getUserId(): number {
    return this.userId;
  }


}
@Component({
  selector: 'app-day-book',
  templateUrl: './day-book.component.html',
  styleUrls: ['./day-book.component.css']
})
export class DayBookComponent implements OnInit {
  from :Date;
  to : Date;
  details: Incomed[] = [] ;
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  subscription: Subscription;
  content :String;
  content2 : String;
  
  headers = ['S NO.', 'Account Name','Date', 'Amount', 'Pay/Receive', 'Remark' ]
  constructor(
    private service : DayBookService,
    private basicAuthService : BasicAuthService
  ) {
    
   } 

  findAllIncome(from, to) {
    this.content = "value";
    this.content2 = this.content;
    this.service.executeFindIncomeBetweenDate(this.basicAuthService.getAccountAuthenticatedUserId(),from, to).subscribe(
      (response: any) => {
        this.details = response;
        this.dtTrigger.next();
      }
    );  
  }
  ngOnInit(): void {

  }

}

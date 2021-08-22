import { Component, OnInit } from '@angular/core';
import { IncomeCategoryService } from 'src/app/service/data/income-category.service';
import { IncomeService } from 'src/app/service/data/income.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
import { IncomeCategories } from 'src/app/table/income-cat-table/income-cat-table.component';

export class Income {
  constructor(
    public incomeId: number,
    public incomeAccount: string,
    public incomeCategoryId: number,
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

  public getIncomeCategoryId(): number {
    return this.incomeCategoryId;
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
  selector: 'app-income',
  templateUrl: './income.component.html',
  styleUrls: ['./income.component.css']
})
export class IncomeComponent implements OnInit {

  income: Income;
  details: IncomeCategories[] = [];
  message: string;
  spinner_status : number = 0;
  constructor(private incomeService: IncomeService, private serviceCatSerice: IncomeCategoryService, private basicAuthService: BasicAuthService) {
    this.income = new Income(0, '', 2, 0, null, 'CI', '', basicAuthService.getAccountAuthenticatedUserId());
  }

  refreshAllCategories() {
    this.serviceCatSerice.executeFindAllIncomeCategories(this.basicAuthService.getAccountAuthenticatedUserId()).subscribe(
      response => {
        this.details = response;
      }
    );
  }

  ngOnInit() {
    this.refreshAllCategories();
  }

  saveIncome(incomesform) {
    this.spinner_status = 1;
    this.incomeService.executeSaveIncome(this.income).subscribe(
      response => {
        this.spinner_status = 0;
        this.message = 'Income Addition Successful';
        incomesform.reset();
      }
    );

  }



  

}

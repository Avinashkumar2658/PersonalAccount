import { Component, OnInit } from '@angular/core';
import { ExpenseCategoryService } from 'src/app/service/data/expense-category.service';
import { ExpenseService } from 'src/app/service/data/expense.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
import { ExpenseCategories } from 'src/app/table/expense-cat-table/expense-cat-table.component';

export class Expense {
  constructor(
    public expenseId: number,
    public expenseAccount: string,
    public expenseCategoryId: number,
    public amount: number,
    public transDate: Date,
    public receiveMode: string,
    public remark: string,
    public userId: number
  ) { }

  public getExpenseId(): number {
    return this.expenseId;
  }
  public getExpenseAccount(): string {
    return this.expenseAccount;
  }

  public getExpenseCategoryId(): number {
    return this.expenseCategoryId;
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
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.css']
})
export class ExpensesComponent implements OnInit {
  expense: Expense;
  details: ExpenseCategories[] = [];
  message: string;
  spinner_status: number = 0;
  constructor(private expenseService: ExpenseService, private serviceCatSerice: ExpenseCategoryService, private basicAuthService: BasicAuthService) {
    this.expense = new Expense(0, '', 2, 0, null, 'CE', '', basicAuthService.getAccountAuthenticatedUserId());
  }

  refreshAllCategories() {
    this.serviceCatSerice.executeFindAllExpenseCategories(this.basicAuthService.getAccountAuthenticatedUserId()).subscribe(
      response => {
        this.details = response;
      }
    );
  }

  ngOnInit() {
    this.refreshAllCategories();
  }

  saveExpense(expenseForm) {
    this.spinner_status = 1;
    this.expenseService.executeSaveExpense(this.expense).subscribe(
      () => {
        this.spinner_status = 0
        this.message = 'Expense Addition Successful';
        expenseForm.reset();
      }
    );
  }
}
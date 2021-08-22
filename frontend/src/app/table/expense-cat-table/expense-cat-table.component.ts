import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Subject } from 'rxjs';

import { Subscription } from 'rxjs';
import { ExpenseCategoryService } from 'src/app/service/data/expense-category.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';

export class ExpenseCategories {

  constructor(
    public expenseCategoryId: number,
    public expenseCategoryName: string,
    public expenseCategoryDetails: string,
    public userId: number
  ) { }

  public getExpenseCategoryId(): number {
    return this.expenseCategoryId;
  }
  public getExpenseCategoryName(): string {
    return this.expenseCategoryName;
  }
  public getExpenseCategoryDetails(): string {
    return this.expenseCategoryDetails;
  }
  public getUserId(): number {
    return this.userId;
  }
}

@Component({
  selector: 'app-expense-cat-table',
  templateUrl: './expense-cat-table.component.html',
  styleUrls: ['./expense-cat-table.component.css']
})

export class ExpenseCatTableComponent implements OnInit {
 
  
  message: string;
  details: ExpenseCategories[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  subscription: Subscription;

  constructor(private service: ExpenseCategoryService, private router: Router, private basicAuthService: BasicAuthService) {

  }
  refreshAllCategories() {
    this.service.executeFindAllExpenseCategories(this.basicAuthService.getAccountAuthenticatedUserId()).subscribe(
      (response: any) => {
        this.details = response;
        this.dtTrigger.next();
      }
    );
  }

  ngOnInit() {
    this.refreshAllCategories();
    this.dtOptions = {
      pagingType: 'full_numbers',
      lengthMenu: [5, 10, 15, 20]
    };



  }

  deleteExpenseCategory(expenseCategoryId) {
    this.service.executeDeleteCategory(expenseCategoryId).subscribe(
      () => {
        this.refreshAllCategories();
        this.message = 'Deleted Expense Category ' + expenseCategoryId;
      }
    );
  }

  updateExpenseCategory(expenseCategoryId) {
    this.router.navigate(['expenseCatForm', expenseCategoryId]);
  }

  addNewExpenseCategory() {
    this.router.navigate(['expenseCatForm', 0]);
  }

  ngOnDestroy() {
    this.dtTrigger.unsubscribe();
  }
}



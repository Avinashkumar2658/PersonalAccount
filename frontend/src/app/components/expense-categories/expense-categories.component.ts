import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ExpenseCategoryService } from 'src/app/service/data/expense-category.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
import { ExpenseCategories } from 'src/app/table/expense-cat-table/expense-cat-table.component';

@Component({
  selector: 'app-expense-categories',
  templateUrl: './expense-categories.component.html',
  styleUrls: ['./expense-categories.component.css']
})



export class ExpenseCategoriesComponent implements OnInit {
  expenseCategory: ExpenseCategories;
  expenseCategoryId: number;
  spinner_status: number = 0;
  constructor(private route: ActivatedRoute, private service: ExpenseCategoryService, private router: Router, private basicAuthService : BasicAuthService) {
    this.expenseCategory = new ExpenseCategories(0, '', '',basicAuthService.getAccountAuthenticatedUserId());
    this.expenseCategoryId = this.route.snapshot.params['expenseCategoryId'];

    if (this.expenseCategoryId != 0) {
      this.service.executeFindExpenseCategory(this.expenseCategoryId).subscribe(
        response => {
          this.expenseCategory = response;
        }
      );
    }
  }

  ngOnInit() {
  }
  saveExpenseCategory(expenseCategoryForm) {
    this.spinner_status = 1;
    if (this.expenseCategoryId != 0) {
      this.service.executeUpdateExpenseCategory(this.expenseCategoryId, this.expenseCategory).subscribe(
        () => {
          this.spinner_status = 0;
          this.router.navigate(['expensescategory']);
          expenseCategoryForm.reset()
        }
      );
    }
    else {
      this.service.executeSaveExpenseCategory(this.expenseCategory).subscribe(
        () => {
          this.router.navigate(['expensescategory']);

        }
      );

    }

  }
}

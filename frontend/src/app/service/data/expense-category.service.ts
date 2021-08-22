import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { APP_URL } from 'src/app.constants';
import { ExpenseCategories } from 'src/app/table/expense-cat-table/expense-cat-table.component';

@Injectable({
  providedIn: 'root'
})
export class ExpenseCategoryService {

  constructor(
    private http: HttpClient
  ) { }


  executeFindAllExpenseCategories(userId) {
    return this.http.get<ExpenseCategories[]>(`${APP_URL}/users/${userId}/expensecategories`);
  }

  executeDeleteCategory(expenseCategoryId) {
     return this.http.delete<String>(`${APP_URL}/expensecategories/${expenseCategoryId}`);
  }

  executeFindExpenseCategory(expenseCategoryId) {
    return this.http.get<ExpenseCategories>(`${APP_URL}/expensecategories/${expenseCategoryId}`);
  }

  executeUpdateExpenseCategory(expenseCategoryId, expenseCategory) {
    return this.http.put<ExpenseCategories>(`${APP_URL}/expensecategories/${expenseCategoryId}`,expenseCategory);
  }

  executeSaveExpenseCategory(expenseCategory) {
    return this.http.post(`${APP_URL}/expensecategories/`,expenseCategory);
  }

}

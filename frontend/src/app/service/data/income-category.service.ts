import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { APP_URL } from 'src/app.constants';
import { IncomeCategories } from 'src/app/table/income-cat-table/income-cat-table.component';



@Injectable({
  providedIn: 'root'
})
export class IncomeCategoryService {
 

  constructor(
    private http: HttpClient
  ) { }


  executeFindAllIncomeCategories(userId: number) {
    return this.http.get<IncomeCategories[]>(`${APP_URL}/users/${userId}/incomecategories`);
  }

  executeDeleteCategory(incomeCategoryId: any) {
     return this.http.delete<String>(`${APP_URL}/incomecategories/${incomeCategoryId}`);
  }

  executeFindIncomeCategory(incomeCategoryId: number) {
    return this.http.get<IncomeCategories>(`${APP_URL}/incomecategories/${incomeCategoryId}`);
  }

  executeUpdateIncomeCategory(incomeCategoryId: Number, incomeCategory: IncomeCategories) {
    return this.http.put<IncomeCategories>(`${APP_URL}/incomecategories/${incomeCategoryId}`,incomeCategory);
  }

  executeSaveIncomeCategory(incomeCategory: IncomeCategories) {
    return this.http.post(`${APP_URL}/incomecategories/`,incomeCategory);
  }

}

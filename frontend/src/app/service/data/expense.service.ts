import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';

@Injectable({
  providedIn: 'root'
})
export class ExpenseService {

  constructor(
    private http: HttpClient
  ) { }

  executeSaveExpense(expense) {
    return this.http.post(`${APP_URL}/expense/`,expense);
  }
  
}

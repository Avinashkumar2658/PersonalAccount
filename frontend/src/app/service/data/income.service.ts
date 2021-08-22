import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';

@Injectable({
  providedIn: 'root'
})
export class IncomeService {

  constructor(
    private http: HttpClient
  ) { }

  executeSaveIncome(income) {
    return this.http.post(`${APP_URL}/incomes/`,income);
  }
}

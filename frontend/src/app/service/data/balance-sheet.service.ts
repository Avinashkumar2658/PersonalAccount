import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';

@Injectable({
  providedIn: 'root'
})
export class BalanceSheetService {

  constructor(private http : HttpClient) { }

  executeFindBalanceSheetBetweenDate(userId, from, to) {
    return this.http.get<any[]>(`${APP_URL}/balanceSheet/${userId}/${from}/to/${to}`);
  }
}

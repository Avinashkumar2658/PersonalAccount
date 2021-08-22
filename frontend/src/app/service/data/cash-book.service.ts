import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';
import { Incomed } from 'src/app/components/day-book/day-book.component';

@Injectable({
  providedIn: 'root'
})
export class CashBookService {

  constructor(
    private http :HttpClient
  ) { }

  executeFindAllCashTransactionBetweenDate(id, from, to) {
    return this.http.get<any[]>(`${APP_URL}/cash/${id}/${from}/to/${to}`);
  }

  executeFindNetAmount(userId) {
    return this.http.get<Object>(`${APP_URL}/netAmount/${userId}`)
  }
}

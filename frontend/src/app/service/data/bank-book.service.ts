import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';

@Injectable({
  providedIn: 'root'
})
export class BankBookService {

  constructor(
    private http :HttpClient
  ) { }

  executeFindAllBankTransactionBetweenDate(id, from, to) {
    return this.http.get<any[]>(`${APP_URL}/bank/${id}/${from}/to/${to}`);
  }

  executeFindNetAmount(userId) {
    return this.http.get<Object>(`${APP_URL}/netAmount/${userId}`)
  }
}

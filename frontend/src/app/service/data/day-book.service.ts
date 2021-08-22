import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { APP_URL } from 'src/app.constants';
import { Incomed } from 'src/app/components/day-book/day-book.component';
import { Income } from 'src/app/components/income/income.component';

@Injectable({
  providedIn: 'root'
})
export class DayBookService {

  constructor(
    private http: HttpClient
  ) { }

  executeFindIncomeBetweenDate(id, from, to) {
    return this.http.get<Incomed[]>(`${APP_URL}/incomes/${id}/${from}/to/${to}`);
  }
}

import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { Subscription } from 'rxjs';
import { IncomeCategoryService } from 'src/app/service/data/income-category.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
export class IncomeCategories {

  constructor(
    public incomeCategoryId: number,
    public incomeCategoryName: string,
    public incomeCategoryDetails: string,
    public userId: number
  ) { }

  public getIncomeCategoryId(): number {
    return this.incomeCategoryId;
  }
  public getIncomeCategoryName(): string {
    return this.incomeCategoryName;
  }
  public getIncomeCategoryDetails(): string {
    return this.incomeCategoryDetails;
  }
  public getUserId(): number {
    return this.userId;
  }
}
@Component({
  selector: 'app-income-cat-table',
  templateUrl: './income-cat-table.component.html',
  styleUrls: ['./income-cat-table.component.css']
})

export class IncomeCatTableComponent implements OnInit {

  message: string;
  details: IncomeCategories[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();
  subscription: Subscription;
  constructor(private service: IncomeCategoryService, private router: Router, private basicAuthService: BasicAuthService) {

  }
  refreshAllCategories() {
    this.service.executeFindAllIncomeCategories(this.basicAuthService.getAccountAuthenticatedUserId()).subscribe(
      (response: any) => {
        this.details = response;
        console.log(response)
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
  deleteIncomeCategory(incomeCategoryId) {
    this.service.executeDeleteCategory(incomeCategoryId).subscribe(
      () => {
        this.refreshAllCategories();
        this.message = 'Deleted Income Category ' + incomeCategoryId;
      }
    );
  }

  updateIncomeCategory(incomeCategoryId) {
    this.router.navigate(['incomeCatForm', incomeCategoryId]);
  }

  addNewIncomeCategory() {
    this.router.navigate(['incomeCatForm', 0]);
  }

  ngOnDestroy() {
    this.dtTrigger.unsubscribe();
  }
}




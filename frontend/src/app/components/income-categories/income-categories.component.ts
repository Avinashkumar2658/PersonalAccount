import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { IncomeCategoryService } from 'src/app/service/data/income-category.service';
import { BasicAuthService } from 'src/app/service/http/basic-auth.service';
import { IncomeCategories } from 'src/app/table/income-cat-table/income-cat-table.component';


@Component({
  selector: 'app-income-categories',
  templateUrl: './income-categories.component.html',
  styleUrls: ['./income-categories.component.css']
})
export class IncomeCategoriesComponent implements OnInit {

  incomeCategory: IncomeCategories;
  incomeCategoryId: number;
  spinner_status : number= 0;
  constructor(private route: ActivatedRoute, private service: IncomeCategoryService, private router: Router, private basicAuthService : BasicAuthService) {
    this.incomeCategory = new IncomeCategories(0, '', '',basicAuthService.getAccountAuthenticatedUserId());
    this.incomeCategoryId = this.route.snapshot.params['incomeCategoryId'];
    console.log(this.incomeCategoryId);
    console.log("value");
    if (this.incomeCategoryId != 0) {
      this.service.executeFindIncomeCategory(this.incomeCategoryId).subscribe(
        response => {
          this.incomeCategory = response;
        }
      );
    }
  }

  ngOnInit() {
  }
  
  saveIncomeCategory(incomeCatForm) {
    this.spinner_status = 1;
    if (this.incomeCategoryId != 0) {
      this.service.executeUpdateIncomeCategory(this.incomeCategoryId, this.incomeCategory).subscribe(
        data => {
          this.spinner_status = 0;
          this.router.navigate(['incomecategory']);
          incomeCatForm.reset();
        }
      );
    }
    else {
      this.service.executeSaveIncomeCategory(this.incomeCategory).subscribe(
        data => {
          this.router.navigate(['incomecategory']);

        }
      );

    }

  }
}

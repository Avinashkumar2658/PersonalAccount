import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserRegistrationComponent } from './components/user-registration/user-registration.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';

import { HeaderComponent } from './components/header/header.component';

import { IncomeCategoriesComponent } from './components/income-categories/income-categories.component';
import { ExpensesComponent } from './components/expense/expense.component';
import { IncomeComponent } from './components/income/income.component';
import { CashBookComponent } from './components/cash-book/cash-book.component';
import { BankBookComponent } from './components/bank-book/bank-book.component';
import { DayBookComponent } from './components/day-book/day-book.component';
import { BalanceSheetComponent } from './components/balance-sheet/balance-sheet.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponentComponent } from './components/login-component/login-component.component';
import { HttpIntercepterBasicAuthService } from './service/http/http-intercepter-basic-auth.service';
import { DataTablesModule } from 'angular-datatables';
import { ExpenseCatTableComponent } from './table/expense-cat-table/expense-cat-table.component';
import { ExpenseCategoriesComponent } from './components/expense-categories/expense-categories.component';
import { IncomeCatTableComponent } from './table/income-cat-table/income-cat-table.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { RsidebarComponent } from './components/rsidebar/rsidebar.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './components/reset-password/reset-password.component';
import { CreatePageComponent } from './components/create-page/create-page.component';
import { DiaryComponent } from './components/diary/diary.component';

@NgModule({
  declarations: [
    AppComponent,
    UserRegistrationComponent,
    SidebarComponent,
    HeaderComponent,
    ExpenseCategoriesComponent,
    IncomeCategoriesComponent,
    ExpensesComponent,
    IncomeComponent,
    CashBookComponent,
    BankBookComponent,
    DayBookComponent,
    BalanceSheetComponent,
    UserProfileComponent,
    LoginComponentComponent,
    IncomeCatTableComponent,
    ExpenseCatTableComponent,
    CalculatorComponent,
    RsidebarComponent,
    ForgotPasswordComponent,
    ResetPasswordComponent,
    CreatePageComponent,
    DiaryComponent,
   

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    DataTablesModule,
    
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: HttpIntercepterBasicAuthService, multi: true },
   
  
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

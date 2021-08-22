import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { BalanceSheetComponent } from './components/balance-sheet/balance-sheet.component';
import { BankBookComponent } from './components/bank-book/bank-book.component';
import { CashBookComponent } from './components/cash-book/cash-book.component';
import { DayBookComponent } from './components/day-book/day-book.component';
import { ExpensesComponent } from './components/expense/expense.component';
import { HeaderComponent } from './components/header/header.component';
import { IncomeComponent } from './components/income/income.component';
import { RouteGuardService } from './service/http/route-guard.service';
import { IncomeCategoriesComponent } from './components/income-categories/income-categories.component';
import { ExpenseCategoriesComponent } from './components/expense-categories/expense-categories.component';
import { IncomeCatTableComponent } from './table/income-cat-table/income-cat-table.component';
import { ExpenseCatTableComponent } from './table/expense-cat-table/expense-cat-table.component';
import { UserRegistrationComponent } from './components/user-registration/user-registration.component';
import { CreatePageComponent } from './components/create-page/create-page.component';
import { DiaryComponent } from './components/diary/diary.component';
import { ResetPasswordComponent } from './components/reset-password/reset-password.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
const routes: Routes = [
  {path: '', component: SidebarComponent, canActivate: [RouteGuardService] },
  {path:'userprofile', component:UserProfileComponent, canActivate: [RouteGuardService]},
  {path:'userRegistration', component:UserRegistrationComponent},
  {path:'balancesheet', component:BalanceSheetComponent, canActivate: [RouteGuardService]},
  {path:'page', component:CreatePageComponent, canActivate: [RouteGuardService]},
  {path:'diary', component:DiaryComponent, canActivate: [RouteGuardService]},
  {path:'bankbook', component:BankBookComponent, canActivate: [RouteGuardService]},
  {path:'cashbook', component:CashBookComponent, canActivate: [RouteGuardService]},
  {path:'daybook', component:DayBookComponent, canActivate: [RouteGuardService]},
  {path:'expensescategory', component:ExpenseCatTableComponent, canActivate: [RouteGuardService]},
  {path:'expenses', component:ExpensesComponent, canActivate: [RouteGuardService]},
  {path:'reset-password/:emailId/:token/:userId', component:ResetPasswordComponent},
  {path:'header', component:HeaderComponent, canActivate: [RouteGuardService]},
  {path: 'income', component:IncomeComponent, canActivate: [RouteGuardService]},   
  {path: 'incomeCatForm/:incomeCategoryId', component: IncomeCategoriesComponent, canActivate: [RouteGuardService] },
  {path: 'expenseCatForm/:expenseCategoryId', component: ExpenseCategoriesComponent, canActivate: [RouteGuardService] },
  {path: 'incomecategory', component: IncomeCatTableComponent, canActivate: [RouteGuardService] },
  {path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }

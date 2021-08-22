import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';
import { ExpenseCategoriesComponent } from './expense-categories.component';



describe('ExpensesCategoriesComponent', () => {
  let component: ExpenseCategoriesComponent;
  let fixture: ComponentFixture<ExpenseCategoriesComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ExpenseCategoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpenseCategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

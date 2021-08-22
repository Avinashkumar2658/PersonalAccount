import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpenseCatTableComponent } from './expense-cat-table.component';

describe('ExpenseCatTableComponent', () => {
  let component: ExpenseCatTableComponent;
  let fixture: ComponentFixture<ExpenseCatTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExpenseCatTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpenseCatTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

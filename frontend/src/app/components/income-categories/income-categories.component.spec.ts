import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { IncomeCategoriesComponent } from './income-categories.component';

describe('IncomeCategoriesComponent', () => {
  let component: IncomeCategoriesComponent;
  let fixture: ComponentFixture<IncomeCategoriesComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ IncomeCategoriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IncomeCategoriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

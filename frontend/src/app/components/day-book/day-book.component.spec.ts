import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { DayBookComponent } from './day-book.component';

describe('DayBookComponent', () => {
  let component: DayBookComponent;
  let fixture: ComponentFixture<DayBookComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ DayBookComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DayBookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

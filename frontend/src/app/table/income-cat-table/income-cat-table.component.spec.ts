import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IncomeCatTableComponent } from './income-cat-table.component';

describe('IncomeCatTableComponent', () => {
  let component: IncomeCatTableComponent;
  let fixture: ComponentFixture<IncomeCatTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IncomeCatTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IncomeCatTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

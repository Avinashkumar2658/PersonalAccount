import { TestBed } from '@angular/core/testing';

import { IncomeCategoryService } from './income-category.service';

describe('IncomeCategoryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IncomeCategoryService = TestBed.get(IncomeCategoryService);
    expect(service).toBeTruthy();
  });
});

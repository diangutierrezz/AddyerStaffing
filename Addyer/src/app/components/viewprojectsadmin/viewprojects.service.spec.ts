import { TestBed } from '@angular/core/testing';

import { ViewprojectsService } from './viewprojects.service';

describe('ViewprojectsService', () => {
  let service: ViewprojectsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewprojectsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

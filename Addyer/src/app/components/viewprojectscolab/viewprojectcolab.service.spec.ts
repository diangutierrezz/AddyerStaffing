import { TestBed } from '@angular/core/testing';

import { ViewprojectcolabService } from './viewprojectcolab.service';

describe('ViewprojectcolabService', () => {
  let service: ViewprojectcolabService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewprojectcolabService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { ViewcolabsService } from './viewcolabs.service';

describe('ViewcolabsService', () => {
  let service: ViewcolabsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewcolabsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

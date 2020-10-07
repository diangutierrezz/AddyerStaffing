import { TestBed } from '@angular/core/testing';

import { ProfilecolabService } from './profilecolab.service';

describe('ProfilecolabService', () => {
  let service: ProfilecolabService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProfilecolabService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

import { TestBed } from '@angular/core/testing';

import { AddSkillService } from './add-skill.service';

describe('AddSkillService', () => {
  let service: AddSkillService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddSkillService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

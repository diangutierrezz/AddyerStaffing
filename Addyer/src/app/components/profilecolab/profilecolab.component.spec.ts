import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfilecolabComponent } from './profilecolab.component';

describe('ProfilecolabComponent', () => {
  let component: ProfilecolabComponent;
  let fixture: ComponentFixture<ProfilecolabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProfilecolabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfilecolabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

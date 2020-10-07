import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogincolabComponent } from './logincolab.component';

describe('LogincolabComponent', () => {
  let component: LogincolabComponent;
  let fixture: ComponentFixture<LogincolabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogincolabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogincolabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

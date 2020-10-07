import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomecolabComponent } from './homecolab.component';

describe('HomecolabComponent', () => {
  let component: HomecolabComponent;
  let fixture: ComponentFixture<HomecolabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomecolabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomecolabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

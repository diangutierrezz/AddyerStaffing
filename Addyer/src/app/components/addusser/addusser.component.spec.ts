import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddusserComponent } from './addusser.component';

describe('AddusserComponent', () => {
  let component: AddusserComponent;
  let fixture: ComponentFixture<AddusserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddusserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddusserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

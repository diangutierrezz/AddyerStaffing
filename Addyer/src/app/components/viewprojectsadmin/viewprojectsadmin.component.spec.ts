import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewprojectsadminComponent } from './viewprojectsadmin.component';

describe('ViewprojectsadminComponent', () => {
  let component: ViewprojectsadminComponent;
  let fixture: ComponentFixture<ViewprojectsadminComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewprojectsadminComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewprojectsadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

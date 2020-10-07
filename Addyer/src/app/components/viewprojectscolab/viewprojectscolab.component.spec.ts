import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewprojectscolabComponent } from './viewprojectscolab.component';

describe('ViewprojectscolabComponent', () => {
  let component: ViewprojectscolabComponent;
  let fixture: ComponentFixture<ViewprojectscolabComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewprojectscolabComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewprojectscolabComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

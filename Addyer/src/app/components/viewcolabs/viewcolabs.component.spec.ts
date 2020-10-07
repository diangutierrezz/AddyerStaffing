import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewcolabsComponent } from './viewcolabs.component';

describe('ViewcolabsComponent', () => {
  let component: ViewcolabsComponent;
  let fixture: ComponentFixture<ViewcolabsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewcolabsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewcolabsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

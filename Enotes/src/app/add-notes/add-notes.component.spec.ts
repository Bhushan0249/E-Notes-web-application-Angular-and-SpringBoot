import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNotesComponent } from './add-notes.component';

describe('AddNotesComponent', () => {
  let component: AddNotesComponent;
  let fixture: ComponentFixture<AddNotesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddNotesComponent]
    });
    fixture = TestBed.createComponent(AddNotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

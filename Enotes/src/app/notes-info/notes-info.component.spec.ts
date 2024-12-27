import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotesInfoComponent } from './notes-info.component';

describe('NotesInfoComponent', () => {
  let component: NotesInfoComponent;
  let fixture: ComponentFixture<NotesInfoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NotesInfoComponent]
    });
    fixture = TestBed.createComponent(NotesInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

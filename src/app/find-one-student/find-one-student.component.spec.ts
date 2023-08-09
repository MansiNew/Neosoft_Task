import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FindOneStudentComponent } from './find-one-student.component';

describe('FindOneStudentComponent', () => {
  let component: FindOneStudentComponent;
  let fixture: ComponentFixture<FindOneStudentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FindOneStudentComponent]
    });
    fixture = TestBed.createComponent(FindOneStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

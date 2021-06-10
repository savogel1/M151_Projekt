import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnterStepsComponent } from './enter-steps.component';

describe('EnterStepsComponent', () => {
  let component: EnterStepsComponent;
  let fixture: ComponentFixture<EnterStepsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnterStepsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EnterStepsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

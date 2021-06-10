import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyStatisticsComponent } from './my-statistics.component';

describe('MyStatisticsComponent', () => {
  let component: MyStatisticsComponent;
  let fixture: ComponentFixture<MyStatisticsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyStatisticsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyStatisticsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

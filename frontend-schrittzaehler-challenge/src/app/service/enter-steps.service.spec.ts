import { TestBed } from '@angular/core/testing';

import { EnterStepsService } from './enter-steps.service';

describe('EnterStepsService', () => {
  let service: EnterStepsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EnterStepsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

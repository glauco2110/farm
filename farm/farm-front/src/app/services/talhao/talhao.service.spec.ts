import { TestBed, inject } from '@angular/core/testing';

import { TalhaoService } from './talhao.service';

describe('TalhaoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TalhaoService]
    });
  });

  it('should be created', inject([TalhaoService], (service: TalhaoService) => {
    expect(service).toBeTruthy();
  }));
});

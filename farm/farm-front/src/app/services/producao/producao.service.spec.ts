import { TestBed, inject } from '@angular/core/testing';

import { ProducaoService } from './producao.service';

describe('ProducaoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProducaoService]
    });
  });

  it('should be created', inject([ProducaoService], (service: ProducaoService) => {
    expect(service).toBeTruthy();
  }));
});

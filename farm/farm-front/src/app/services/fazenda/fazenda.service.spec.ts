import { TestBed, inject } from '@angular/core/testing';

import { FazendaService } from './fazenda.service';

describe('FazendaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [FazendaService]
    });
  });

  it('should be created', inject([FazendaService], (service: FazendaService) => {
    expect(service).toBeTruthy();
  }));
});

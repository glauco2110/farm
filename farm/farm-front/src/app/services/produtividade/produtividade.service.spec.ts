import { TestBed, inject } from '@angular/core/testing';

import { ProdutividadeService } from './produtividade.service';

describe('ProdutividadeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ProdutividadeService]
    });
  });

  it('should be created', inject([ProdutividadeService], (service: ProdutividadeService) => {
    expect(service).toBeTruthy();
  }));
});

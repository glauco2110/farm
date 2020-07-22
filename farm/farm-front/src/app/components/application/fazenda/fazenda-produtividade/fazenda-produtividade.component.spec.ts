import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FazendaProdutividadeComponent } from './fazenda-produtividade.component';

describe('FazendaProdutividadeComponent', () => {
  let component: FazendaProdutividadeComponent;
  let fixture: ComponentFixture<FazendaProdutividadeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FazendaProdutividadeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FazendaProdutividadeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

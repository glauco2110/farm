import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FazendaConsultarComponent } from './fazenda-consultar.component';

describe('FazendaConsultarComponent', () => {
  let component: FazendaConsultarComponent;
  let fixture: ComponentFixture<FazendaConsultarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FazendaConsultarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FazendaConsultarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

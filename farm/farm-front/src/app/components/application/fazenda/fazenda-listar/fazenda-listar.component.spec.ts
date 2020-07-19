import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FazendaListarComponent } from './fazenda-listar.component';

describe('FazendaListarComponent', () => {
  let component: FazendaListarComponent;
  let fixture: ComponentFixture<FazendaListarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FazendaListarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FazendaListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

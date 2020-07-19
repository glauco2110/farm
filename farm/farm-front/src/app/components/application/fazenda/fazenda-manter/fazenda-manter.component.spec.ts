import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FazendaManterComponent } from './fazenda-manter.component';

describe('FazendaManterComponent', () => {
  let component: FazendaManterComponent;
  let fixture: ComponentFixture<FazendaManterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FazendaManterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FazendaManterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

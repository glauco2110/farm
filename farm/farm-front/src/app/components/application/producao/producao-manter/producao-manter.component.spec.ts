import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProducaoManterComponent } from './producao-manter.component';

describe('ProducaoManterComponent', () => {
  let component: ProducaoManterComponent;
  let fixture: ComponentFixture<ProducaoManterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProducaoManterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProducaoManterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TalhaoManterComponent } from './talhao-manter.component';

describe('TalhaoManterComponent', () => {
  let component: TalhaoManterComponent;
  let fixture: ComponentFixture<TalhaoManterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TalhaoManterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TalhaoManterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

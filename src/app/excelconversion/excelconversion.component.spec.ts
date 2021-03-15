import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExcelconversionComponent } from './excelconversion.component';

describe('ExcelconversionComponent', () => {
  let component: ExcelconversionComponent;
  let fixture: ComponentFixture<ExcelconversionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExcelconversionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExcelconversionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

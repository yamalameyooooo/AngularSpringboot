import { ComponentFixture, TestBed } from '@angular/core/testing';

import { McpdataComponent } from './mcpdata.component';

describe('McpdataComponent', () => {
  let component: McpdataComponent;
  let fixture: ComponentFixture<McpdataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ McpdataComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(McpdataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

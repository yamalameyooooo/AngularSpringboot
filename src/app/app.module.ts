import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ExcelconversionComponent } from './excelconversion/excelconversion.component';
import { McpdataComponent } from './mcpdata/mcpdata.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { ContactComponent } from './contact/contact.component';

@NgModule({
  declarations: [
    AppComponent,
    ExcelconversionComponent,
    McpdataComponent,
    ContactComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot({closeButton:true,progressBar:true,positionClass:'toast-top-center',timeOut:7000}),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactComponent } from './contact/contact.component';
import { ExcelconversionComponent } from './excelconversion/excelconversion.component';
import { McpdataComponent } from './mcpdata/mcpdata.component';

const routes: Routes = [
{ path: 'excelconv', component: ExcelconversionComponent },
{ path: 'mcp', component: McpdataComponent },
{ path: 'contact', component: ContactComponent }];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule {}



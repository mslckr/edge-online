import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { CatalogComponent } from './catalog/catalog.component';
import { TemplateComponent } from './template/template.component';

@NgModule({
  declarations: [
    AppComponent,
    CatalogComponent,
    TemplateComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      { path: 'catalog', component: CatalogComponent }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

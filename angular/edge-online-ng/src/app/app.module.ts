import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { CatalogComponent } from './catalog/catalog.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { CartComponent } from './cart/cart.component';

import { DataService } from './services/data.service';
import { ConstantsService } from './services/constants.service';
import { CheckoutComponent } from './checkout/checkout.component';
import { CartItemComponent } from './cart/cart-item/cart-item.component';

@NgModule({
  declarations: [
    AppComponent,
    CatalogComponent,
    HomeComponent,
    AboutComponent,
    CartComponent,
    CheckoutComponent,
    CartItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [DataService, ConstantsService],
  bootstrap: [AppComponent]
})
export class AppModule {
  title = ""
  setHeaderTitle(title) {

  }
}

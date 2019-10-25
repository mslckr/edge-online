import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule }    from '@angular/forms';

import { AppComponent } from './app.component';
import { CatalogComponent } from './catalog/catalog.component';
import { HomeComponent } from './home/home.component';
import { AboutComponent } from './about/about.component';
import { CartComponent } from './cart/cart.component';

import { DataService } from './services/data.service';
import { ConstantsService } from './services/constants.service';
import { CheckoutComponent } from './checkout/checkout.component';
import { CartItemComponent } from './cart/cart-item/cart-item.component';
import { OrderConfirmationComponent } from './order-confirmation/order-confirmation.component';
import { ItemFilterNamePipe } from './filters/item-filter-name.pipe';
import { ItemFilterStockPipe } from './filters/item-filter-stock.pipe';
import { ItemFilterProviderPipe } from './filters/item-filter-provider.pipe';
import { ItemFilterCategoryPipe } from './filters/item-filter-category.pipe';

@NgModule({
  declarations: [
    AppComponent,
    CatalogComponent,
    HomeComponent,
    AboutComponent,
    CartComponent,
    CheckoutComponent,
    CartItemComponent,
    OrderConfirmationComponent,
    ItemFilterNamePipe,
    ItemFilterStockPipe,
    ItemFilterProviderPipe,
    ItemFilterCategoryPipe
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
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

import { NgModule} from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CatalogComponent } from './catalog/catalog.component';
import { HomeComponent } from './home/home.component'
import { CartComponent } from './cart/cart.component'
import { AboutComponent } from './about/about.component';
import { CheckoutComponent} from './checkout/checkout.component'
import { OrderConfirmationComponent} from './order-confirmation/order-confirmation.component'

const routes: Routes = [
    { path: 'catalog', component: CatalogComponent },
    { path: 'home', component: HomeComponent },
    { path: 'about', component: AboutComponent },
    {path: 'cart', component: CartComponent },
    {path: 'checkout', component: CheckoutComponent },
    {path: 'confirmation', component: OrderConfirmationComponent },
    {path: '', redirectTo: '/home', pathMatch: 'full'},
  ];

  @NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }
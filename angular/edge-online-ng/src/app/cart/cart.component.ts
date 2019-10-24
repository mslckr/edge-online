import { Component, OnInit } from '@angular/core';
import { Cart } from '../model/cart.model';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  title= "Cart";
  
  cart: Cart;
  

  constructor(private cartService: CartService) { 
  }

  ngOnInit() {
    this.cart=this.cartService.createTestCart();
  }

  getCartSession(){
    this.cart= this.cartService.getCart();
    
  }

  clearCart(){
    this.cart=this.cartService.removeAll();
  }
}

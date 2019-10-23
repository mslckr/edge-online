import { Component, OnInit } from '@angular/core';
import { Cart } from '../model/cart.model'
@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  //cartItems: Cart[];
  cartItem: Cart;
  quantity: number;
  total: number;

  constructor() { 
    //this.cartItem.
    this.quantity=10;
    this.total=200;
  }

  ngOnInit() {
    //this.getCartSession();
  }

  getCartSession(){
    return localStorage.getItem("currentCart");
  }
}

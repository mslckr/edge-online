import { Component, OnInit } from '@angular/core';
import { Cart } from '../model/cart.model';
import { CartService } from '../services/cart.service'

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  title= "Cart";
  
  //cartItems: Cart[];
  cart: Cart= {
    cartItems: [{
      itemId: 4,
      name: "gtx 4",
      category: "Graphic Cards",
      price: 150,
      image: "",
      rating: 5,
      stock: 25,
      provider: null,
      quantity:1,
      total_amount:150
    },
    {
      itemId: 7,
      name: "gtx 2",
      category: "Graphic Cards",
      price: 100,
      image: "",
      rating: 5,
      stock: 25,
      provider: null,
      quantity:1,
      total_amount:100
    },
    {
      itemId: 10,
      name: "gtx 25",
      category: "Graphic Cards",
      price: 200,
      image: "",
      rating: 5,
      stock: 25,
      provider: null,
      quantity:1,
      total_amount:200
    }
  ],
    quantity: 2,
    Total: 125

  };
  

  constructor(private cartService: CartService) { 
    //this.cartItem.
    //this.quantity=10;
    //this.total=200;
  }

  ngOnInit() {
  }

  getCartSession(){
    return localStorage.getItem("currentCart");
  }

  clearCart(){
    this.cartService.removeAll();
  }
}
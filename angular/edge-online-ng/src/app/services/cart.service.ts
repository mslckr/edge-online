import { Injectable } from '@angular/core';
import { Cart } from '../model/cart.model'
import { Item } from '../model/item.model';

@Injectable({
  providedIn: 'root'
})

export class CartService {

  constructor() { }

  //add item to our session cart
  addToCart(cartItem: Item){
    let curr_cart: Cart =JSON.parse(sessionStorage.getItem("currentCart"));
    
    if(curr_cart.cartItems.find(i => i.itemId== cartItem.itemId) == undefined)
      curr_cart.cartItems.push(cartItem);
    
      curr_cart.quantity += 1;
    curr_cart.Total += cartItem.price;

    sessionStorage.setItem("currentCart",JSON.stringify(curr_cart));
    
  }

  // remove cart item from our cart
  removeCartItem(cartItemId: number){
      let curr_cart: Cart = JSON.parse(sessionStorage.getItem("currentCart"));
      let removeItem: Item =curr_cart.cartItems.find(i => i.itemId == cartItemId);

      if(removeItem != undefined){
        curr_cart.cartItems.splice(removeItem.itemId);
        curr_cart.quantity -= 1;
        curr_cart.Total -= removeItem.price;
      }
      sessionStorage.setItem("currentCart",JSON.stringify(curr_cart));
  }

  //update cart item Quantity passing in the old quantity and new quantity
  updateCartItemQuantity(cartItem: Item, old_quantity, updated_quantity: number){
    let curr_cart: Cart = JSON.parse(sessionStorage.getItem("currentCart"));
    let oldItemTotal = cartItem.price * old_quantity;
    curr_cart.Total -= oldItemTotal;
    let newItemTotal = cartItem.price * updated_quantity;
    curr_cart.Total += newItemTotal;

    sessionStorage.setItem("currentCart",JSON.stringify(curr_cart));
  }

  removeAll(){
    sessionStorage.clear();
  }

}

import { Injectable } from '@angular/core';
import { Cart, CartItem } from '../model/cart.model'
import { Item } from '../model/item.model';

@Injectable({
  providedIn: 'root'
})

export class CartService {

  constructor() { }

  //add item to our session cart
  addToCart(addedItem: Item){
    let curr_cart: Cart =JSON.parse(sessionStorage.getItem("currentCart"));
    let cartItem = new CartItem(addedItem);

    //if item is not in cart then add it to the cart
    if(curr_cart.cartItems.find(i => i.itemId== cartItem.itemId) == undefined){
      curr_cart.cartItems.push(cartItem);
    }
    //else update the quantity and total of that cartItem
    else{
    curr_cart.quantity +=1;
    curr_cart.Total = cartItem.price * cartItem.quantity;
    }
    //save changes
    sessionStorage.setItem("currentCart",JSON.stringify(curr_cart));
    
  }

  // remove cart item from our cart
  removeCartItem(cartItemId: number){
      let curr_cart: Cart = JSON.parse(sessionStorage.getItem("currentCart"));
      let removeCartItem: CartItem =curr_cart.cartItems.find(i => i.itemId == cartItemId);

      if(removeCartItem != undefined){
        if(removeCartItem.quantity > 0)
          curr_cart.cartItems[removeCartItem.itemId].quantity -=1;
        else{
          curr_cart.cartItems.splice(removeCartItem.itemId);
          //curr_cart.quantity -= 1;
          curr_cart.Total -= removeCartItem.price;
        }
        sessionStorage.setItem("currentCart",JSON.stringify(curr_cart));
      }
  }

  //update cart item Quantity passing in the old quantity and new quantity
  /*updateCartItemQuantity(cartItem: CartItem){
    let curr_cart: Cart = JSON.parse(sessionStorage.getItem("currentCart"));
    let oldItemTotal = cartItem.price * old_quantity;
    curr_cart.Total -= oldItemTotal;
    let newItemTotal = cartItem.price * updated_quantity;
    curr_cart.Total += newItemTotal;

    sessionStorage.setItem("currentCart",JSON.stringify(curr_cart));
  }*/

  removeAll(){
    sessionStorage.clear();
  }

}

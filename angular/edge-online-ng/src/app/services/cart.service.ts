import { Injectable } from '@angular/core';
import { Cart, CartItem } from '../model/cart.model'
import { Item } from '../model/item.model';

@Injectable({
  providedIn: 'root'
})

export class CartService {
  cart: Cart;
  constructor() { }
  
  createTestCart(): Cart{
    sessionStorage.setItem("currentCart",JSON.stringify(this.cart));
    return this.cart;
  }
  getCart(): Cart{
    
    if(sessionStorage.length > 0) {
      return JSON.parse(sessionStorage.getItem("currentCart"));
    }
    else {
      return new Cart();
    }
  }

  //add item to our session cart
  addToCart(addedItem: Item){
    
    this.cart = this.getCart();
    let cartItem = new CartItem(addedItem);
    console.log(cartItem.item);
    //if item is not in cart then add it to the cart
    let cartItemIdx = this.cart.cartItems.findIndex((i: CartItem) => i.item.itemId== cartItem.item.itemId)
    if(cartItemIdx == -1){
      this.cart.cartItems.push(cartItem);
    }
    //else update the quantity and total of that cartItem
    else{
      this.cart.cartItems[cartItemIdx].quantity +=1;
      this.cart.cartItems[cartItemIdx].total_amount = cartItem.item.price * this.cart.cartItems[cartItemIdx].quantity;
    }
    //update the quantity and total of the cart
    this.cart.quantity +=1;
    this.cart.total += cartItem.item.price;
    //save changes
    sessionStorage.setItem("currentCart",JSON.stringify(this.cart));
    
  }

  // remove cart item from our cart
  removeCartItem(cartItemId: number): Cart{
      //this.cart = this.getCart()
      
      let rmvCartItemIdx =this.cart.cartItems.findIndex(i => i.item.itemId == cartItemId);
      
      if(rmvCartItemIdx != -1){
        this.cart.quantity -= 1;
        this.cart.total -= this.cart.cartItems[rmvCartItemIdx].item.price;
        
        //if the cartitem to remove quantity is greater than 1, quantity-- and totalamount - price
        if(this.cart.cartItems[rmvCartItemIdx].quantity > 1){
          this.cart.cartItems[rmvCartItemIdx].quantity -=1;
          this.cart.cartItems[rmvCartItemIdx].total_amount -= this.cart.cartItems[rmvCartItemIdx].item.price;
        }
        //
        else{
          this.cart.cartItems.splice(rmvCartItemIdx,1);
        }
        
        sessionStorage.setItem("currentCart",JSON.stringify(this.cart));
      }
      return this.cart;
  }

  removeAll(): Cart{
    this.cart = this.getCart();
    if(this.cart.quantity > 0){
      this.cart.cartItems=[];
      this.cart.total=0;
      this.cart.quantity=0;
      sessionStorage.clear();
    }
    return this.cart;
  }

}

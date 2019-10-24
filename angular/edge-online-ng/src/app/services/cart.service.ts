import { Injectable } from '@angular/core';
import { Cart, CartItem } from '../model/cart.model'
import { Item } from '../model/item.model';

@Injectable({
  providedIn: 'root'
})

export class CartService {
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
      quantity:2,
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
    quantity: 3,
    Total: 125

  };
  constructor() { }
  
  createTestCart(): Cart{
    sessionStorage.setItem("currentCart",JSON.stringify(this.cart));
    return this.cart;
  }
  getCart(): Cart{
    return JSON.parse(sessionStorage.getItem("currentCart"));
  }

  //add item to our session cart
  addToCart(addedItem: Item){
    let curr_cart: Cart = JSON.parse(sessionStorage.getItem("currentCart"));
    let cartItem = new CartItem(addedItem);

    //if item is not in cart then add it to the cart
    if(curr_cart.cartItems.find(i => i.itemId== cartItem.itemId) == undefined){
      curr_cart.cartItems.push(cartItem);
    }
    //else update the quantity and total of that cartItem
    else{
      cartItem.quantity +=1;
      cartItem.total_amount = cartItem.price * cartItem.quantity;
    }
    //update the quantity and total of the cart
      curr_cart.quantity +=1;
      curr_cart.Total = cartItem.price * cartItem.quantity;
    //save changes
    sessionStorage.setItem("currentCart",JSON.stringify(curr_cart));
    
  }

  // remove cart item from our cart
  removeCartItem(cartItemId: number){
      let curr_cart: Cart = JSON.parse(sessionStorage.getItem("currentCart"));
      let removeCartItem: CartItem =curr_cart.cartItems.find(i => i.itemId == cartItemId);

      if(removeCartItem != undefined){
        //if the cartitem to remove quantity is greater than 1, quantity-- and totalamount - price
        if(removeCartItem.quantity > 1){
          curr_cart.cartItems[removeCartItem.itemId].quantity -=1;
          curr_cart.cartItems[removeCartItem.itemId].total_amount -= removeCartItem.price;
        }
        //
        else{
          curr_cart.cartItems.splice(removeCartItem.itemId);
        }

        curr_cart.quantity -= 1;
        curr_cart.Total -= removeCartItem.price;
        console.log(curr_cart);
        sessionStorage.setItem("currentCart",JSON.stringify(curr_cart));
       
        this.cart=curr_cart;
      }
  }

  removeAll(): Cart{
    this.cart.cartItems=[];
    this.cart.Total=0;
    this.cart.quantity=0;
    sessionStorage.clear();
    return this.cart;
  }

}

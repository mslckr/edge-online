import { Item } from './item.model';

export class Cart {
  cartItems: any;
  quantity: number = 0;
  total: number = 0.0;
}

export class CartItem {
  item: Item;
  quantity: number;
  total_amount: number;
  
  constructor(item: Item){
    this.item= item;
    this.quantity=1;
    this.total_amount= item.item_price * this.quantity;
  }
}


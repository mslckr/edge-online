import { Item } from './item.model';

export class Cart {
  cartItems: any[] =[];
  quantity: number = 0;
  total: number = 0.0;
}

export class CartItem {
  item: Item;
  quantity: number;
  total_amount: number;
  
  constructor(item: Item){
    this.item= item;
    // this.item.name= item.name;
    // this.item.category= item.category;
    // this.item.price= item.price;
    // this.item.image= item.image;
    // this.item.rating= item.rating;
    // this.item.stock= item.stock;
    // this.item.provider= item.provider;
    this.quantity=1;
    this.total_amount= item.price * this.quantity;
  }
}


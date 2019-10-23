import { Item } from './item.model';

export class Cart {
  cartItems: CartItem[];
  quantity: number;
  Total: number;
}

export class CartItem extends Item{
  quantity: number;
  total_amount: number;
  
  constructor(item: Item){
    super();
    this.itemId= item.itemId;
    this.name= item.name;
    this.category= item.category;
    this.price= item.price;
    this.image= item.image;
    this.rating= item.rating;
    this.stock= item.stock;
    this.provider= item.provider;
    this.quantity=1;
    this.total_amount= item.price;
  }
}


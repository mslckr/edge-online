import { Injectable } from '@angular/core';
import { Item } from './item.model';
import { DataService } from '../services/data.service';

// ---------------------------------------------------
export class itemSelection {
  constructor(public cart: Cart,
    public itemId?: number,
    public name?: string,
    public price?: number,
    private quantityValue?: number) { }
  
    get quantity() {
    return this.quantityValue;
  }
  set quantity(newQuantity: number) {
    this.quantityValue = newQuantity;
    this.cart.update();
  }
}

@Injectable()
export class Cart {
  selections: itemSelection[] = [];
  itemCount = 0;
  totalPrice = 0;
  // ---------------------------------------------------
  constructor(private repo: DataService) {
    repo.getSessionData('cart').subscribe(cartData => {
      if (cartData != null && cartData.selections.length > 0) {
        cartData.selections.map(item => new itemSelection(this, item.itemId,
          item.name, item.price, item.quantity))
          .forEach(item => this.selections.push(item));
        this.update(false);
      }
    });
  }

  addItem(item: Item) {
    const selection = this.selections.find(ps => ps.itemId === item.itemId);
    if (selection) {
      selection.quantity++;
    } else {
      this.selections.push(new itemSelection(this,
        item.itemId, item.name,
        item.price, 1));
    }
    this.update();
  }
  // ---------------------------------------------------
  updateQuantity(itemId: number, quantity: number) {
    if (quantity > 0) {
      const selection = this.selections.find(ps => ps.itemId === itemId);
      if (selection) {
        selection.quantity = quantity;
      }
    } else {
      const index = this.selections.findIndex(ps => ps.itemId === itemId);
      if (index !== -1) {
        this.selections.splice(index, 1);
      }
      this.update();
    }
  }
  // ---------------------------------------------------
  clear() {
    this.selections = [];
    this.update();
  }
  // ---------------------------------------------------
  update(storeData: boolean = true) {
    this.itemCount = this.selections.map(ps => ps.quantity)
      .reduce((prev, curr) => prev + curr, 0);
    this.totalPrice = this.selections.map(ps => ps.price * ps.quantity)
      .reduce((prev, curr) => prev + curr, 0);

    // Added for session handling
    if (storeData) {
      this.repo.storeSessionData('cart', this.selections.map(s => {
        return {
          movieId: s.itemId,
          name: s.name,
          price: s.price,
          quantity: s.quantity
        };
      }));
    }
  }
}


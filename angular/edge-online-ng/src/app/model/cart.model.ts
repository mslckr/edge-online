import { Injectable } from '@angular/core';
import { Item } from './item.model';
import { DataService } from '../services/data.service';

// ---------------------------------------------------
export class Cart {
  cartItems: Item[];
  quantity: number;
  Total: number;
}


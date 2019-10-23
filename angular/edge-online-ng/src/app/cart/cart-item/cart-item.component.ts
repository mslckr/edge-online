import { Component, OnInit, Input} from '@angular/core';
import { Item } from 'src/app/model/item.model';

@Component({
  selector: 'app-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.css']
})
export class CartItemComponent implements OnInit {
  @Input("cartItem") cartItem: Item;
  constructor() { }

  ngOnInit() {
  }

}

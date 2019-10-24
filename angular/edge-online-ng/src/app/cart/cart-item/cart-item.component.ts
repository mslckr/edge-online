import { Component, OnInit, Input} from '@angular/core';
import { CartItem } from '../../model/cart.model';
import { CartService } from '../../services/cart.service'

@Component({
  selector: 'app-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.css']
})
export class CartItemComponent implements OnInit {
  @Input("cartItem") cartItem: CartItem;
  @Input("page") page: String;

  constructor(private cartService: CartService) { }

  ngOnInit() {
  }

  removeCartItem(){
    this.cartService.removeCartItem(this.cartItem.itemId);
  }

}

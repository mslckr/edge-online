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

  constructor(private cartService: CartService) { }

  ngOnInit() {
  }

  removeCartItem(cartItem_id: number){
    this.cartService.removeCartItem(cartItem_id);
  }

}

import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { Router } from '@angular/router';
import { CartItem, Cart } from '../../model/cart.model';
import { CartService } from '../../services/cart.service';


@Component({
  selector: 'app-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.css']
})
export class CartItemComponent implements OnInit {
  @Input("cartItem") cartItem: CartItem;
  @Input("page") page: String;
  @Input("cart") cart: Cart;
  @Output() cartUpdate =new EventEmitter<Cart>();

  constructor(private cartService: CartService, private router: Router) { }

  ngOnInit() {
  }

  removeCartItem(){
    this.cart=this.cartService.removeCartItem(this.cartItem.itemId);
    console.log(this.cart);
    this.cartUpdate.emit(this.cart);
  }

}

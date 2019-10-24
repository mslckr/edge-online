import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from '../model/cart.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CartService } from '../services/cart.service';
import { CheckoutService } from '../services/checkout.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  title="Checkout";

  cart: Cart;
  checkoutForm: FormGroup;

  constructor( private formBuilder: FormBuilder,
    private cartService: CartService, private router: Router,private checkoutService: CheckoutService) { }

  ngOnInit() {
    this.getCartSession();
    this.checkoutForm = this.formBuilder.group({
      name: ['', Validators.required],
      address: ['', Validators.required],
      cardnumber: ['', [Validators.required, Validators.pattern('[0-9]{12}')]],
      securitycode: ['', [Validators.required,Validators.pattern('[0-9]{3}')]],
      exp_mm: ['', [Validators.required, Validators.pattern('[0-9]{2}')]],
      exp_yy: ['', [Validators.required, Validators.pattern('[0-9]{2}')]]
  });
  }

  onSubmit(){
    if (this.checkoutForm.invalid) {
      console.log("invalid form try again");
      return;
    }
    else{
      this.checkoutService.submitOrder(this.checkoutForm.value)
          .subscribe(
              data => {
                  console.log(data);
                  console.log("Order Complete");
                  //this.alertService.success('Registration successful', true);
                  this.router.navigate(['/confirmation']);
              },
              error => {
                  console.log(error);
                  //this.alertService.error(error);
                  //this.loading = false;
              });
  }
      console.log("Order Complete");
      this.router.navigate(['/confirmation']);
    }

  getCartSession(){
    this.cart= this.cartService.getCart();
  }

}

import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { Cart } from '../model/cart.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  title="Checkout";

  cart: Cart= {
    cartItems: [{
      itemId: 4,
      name: "gtx 4",
      category: "Graphic Cards",
      price: 150,
      image: "",
      rating: 5,
      stock: 25,
      provider: null,
      quantity:1,
      total_amount:150
    },
    {
      itemId: 7,
      name: "gtx 2",
      category: "Graphic Cards",
      price: 100,
      image: "",
      rating: 5,
      stock: 25,
      provider: null,
      quantity:1,
      total_amount:100
    },
    {
      itemId: 10,
      name: "gtx 25",
      category: "Graphic Cards",
      price: 200,
      image: "",
      rating: 5,
      stock: 25,
      provider: null,
      quantity:1,
      total_amount:200
    },
    {
      itemId: 12,
      name: "gtx 125",
      category: "Graphic Cards",
      price: 220,
      image: "",
      rating: 5,
      stock: 25,
      provider: null,
      quantity:1,
      total_amount:220
    }
  ],
    quantity: 4,
    Total: 125

  };

  checkoutForm: FormGroup;

  constructor( private formBuilder: FormBuilder,private cartService: CartService, private router: Router) { }

  ngOnInit() {
    //this.cart= JSON.parse(sessionStorage.getItem("currentCart"));
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
  console.log("Order Complete");
  this.router.navigate(['/confirmation']);
  }

}

import { Cart } from './cart.model';

export class Payment {
  constructor(public cardNumber: string,
    public cardSecurityCode: string,
  public cardExpiry_m: string,
  public cardExpiry_y: string){}
}
export class OrderConfirmation {
  orderId: number;
  authCode: number;
  amount: number;
}
export class Order{
   constructor(public cart: Cart, public orderLine: OrderLine, public complete: Boolean){}
}
export class OrderLine {
  public orderId: number;
  public name: string;
  public address: string;
  public payment: Payment;
  public order_stage: number=10;
  public auth_code: number;
  public cart: Cart;
  public orderConfirmation: OrderConfirmation;
  }


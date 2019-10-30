import { Cart } from './cart.model';

export class Payment {
  constructor(){}
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
  public user_name: string;
  public user_address: string;
  public user_card_no: string;
  public user_card_sec: number;
  public user_card_expdate: string
  //public payment: Payment;
  public order_stage: number=10;
  public auth_code: number;
  public cart: Cart;
  //public orderConfirmation: OrderConfirmation;
  }


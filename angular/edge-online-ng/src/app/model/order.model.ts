export class Payment {
  cardNumber: string;
  cardExpiry: string;
  cardSecurityCode: string;
}
export class OrderConfirmation {
  constructor(public orderId: number,
    public authCode: string,
    public amount: number) { }
}

export class Order {

  orderId: number;
  name: string;
  address: string;
  payment: Payment = new Payment();
  submitted = false;
  shipped = false;
  status_stage=10;
  orderConfirmation: OrderConfirmation;
  }


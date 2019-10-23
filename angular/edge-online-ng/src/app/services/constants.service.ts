import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ConstantsService {

  readonly apiUrl: string = 'http://localhost:8080';
  readonly API_ENDPOINT = 'http://localhost:8080/api';
  readonly providersUrl = this.API_ENDPOINT + '/providers';
  readonly itemsUrl = this.API_ENDPOINT + '/items';
  readonly ordersUrl = this.API_ENDPOINT + '/orders';
  readonly sessionsUrl = this.API_ENDPOINT + '/session';

}

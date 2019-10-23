import { Injectable } from '@angular/core';
import { Item } from '../model/item.model'
import { HttpClient, HttpHeaders} from '@angular/common/http';
//import { Filter, Pagination } from './configClasses.data';
import { Provider } from '../model/provider.model';
import { Order } from '../model/order.model';
import { Subject, Observable } from 'rxjs';
import { ConstantsService} from './constants.service';


@Injectable({
  providedIn: 'root'
})
export class DataService {


  constructor(private http: HttpClient, private constants: ConstantsService) { 
  }

  getAllItems(){
    return this.http.get(`${this.constants.itemsUrl}`);
  }
  //Advance Search
  getFilterItems(name: string, category: string, provider: string, inStockOnly: boolean){
    let obs = this.http.get(`${this.constants.itemsUrl}?name=${name}&category=${category}&provider=${provider}&inStockOnly=${inStockOnly}`);
  return obs;
  }

  getItemById(id: number){
    let obs = this.http.get(`${this.constants.itemsUrl}/id`);
  return obs;
  }

  /**------------------ admin screen functions------------------ */

  getAllProviders(){
    return this.http.get<Provider[]>(this.constants.providersUrl);
  }

  //Don't subscribe here, subscribe on the component
  createItem(item: Item) {
    return this.http.post<Item>(this.constants.itemsUrl, item, { withCredentials: true });
  }
    /*.subscribe(response => {
        item.itemId = response.itemId;
        this.items.push(item);
      });*/
  //Don't subscribe here, subscribe on the component
  createItemAndProvider(item: Item, prov: Provider) {
    const data = {
      name: prov.name, address: prov.address, logo: prov.logo, link: prov.link
    };
    return this.http.post<number>(this.constants.providersUrl, data);
      /*.subscribe(response => {
        prov.providerId = response;
        item.provider = prov;
        this.providers.push(prov);
        if (item != null) {
          this.createItem(item);
        }
      });*/
  }
  
  //Don't subscribe here,
  replaceItem(item: Item) {
    /*const data = {
      image: item.image, name: item.name, category: item.category,
      price: item.price, stock: item.stock, rating: item.rating,
      provider: item.provider ? item.provider.providerId : 0
    };*/
    return this.http.put(this.constants.itemsUrl + '/' + item.itemId, item );
  }

  replaceProvider(prov: Provider) {
    const data = {
      name: prov.name, address: prov.address, logo: prov.logo, link: prov.link
    };
    return this.http.put(this.constants.providersUrl + '/' + prov.providerId, data)//
    //.subscribe(response => this.getItems());
  }

  updateItem(id: number, changes: Map<string, any>) {
    const patch = [];
    changes.forEach((value, key) =>
      patch.push({ op: 'replace', path: key, value: value }));
    this.http.patch(this.constants.itemsUrl + '/' + id, patch)
      //.subscribe(response => this.getItems());
  }

  deleteItem(id: number) {
    this.http.delete(this.constants.itemsUrl + '/' + id);
      //.subscribe(response => this.getMovies());
  }

  deleteProvider(id: number) {
    return this.http.delete(this.constants.providersUrl + '/' + id)
      /*.subscribe(response => {
        this.getMovies();
        this.getStudios();
      });*/
  }

  getOrders() {
    return this.http.get<Order[]>(this.constants.ordersUrl);
    //.subscribe(data => this.orders = data);
  }

  createOrder(order: Order) {
    return this.http.post<any>(this.constants.ordersUrl, {
      name: order.name,
      address: order.address,
      payment: order.payment
    }, { withCredentials: true });
  }
   /* .subscribe(data => {
      order.orderConfirmation = data;
      order.cart.clear();
      order.clear();
    });
  }*/

  shipOrder(order: Order) {
   return this.http.post(this.constants.ordersUrl + '/' + order.orderId, null, { withCredentials: true });
  }
}

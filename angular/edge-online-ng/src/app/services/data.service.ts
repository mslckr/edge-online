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
  //private filterObject = new Filter();
  //private paginationObject = new Pagination();
  pageChange: Subject<number> = new Subject();
  itemListFetched: Subject<boolean> = new Subject();

  item: Item;
  items: Item[];
  providers: Provider[]=[];
  orders: Order[] =[];

  constructor(private http: HttpClient, private constants: ConstantsService) { 
    //this.filter.inStockOnly= false;
    //this.getAllItems();
  }

  subscribeToPageChange(): Subject<number> {
    return this.pageChange;
  }

  subscribeToItemFetch(): Subject<boolean> {
    return this.itemListFetched;
  }

  /*changePage(page: number) {
    this.pagination.currentPage = page;
    this.pageChange.next(page);
  }*/

  //Advance Search
  getAllItems(name: string, category: string, provider: string, inStockOnly: boolean){
    let obs = this.http.get(`${this.constants.itemsUrl}?name=${name}&category=${category}&provider=${provider}&inStockOnly=${inStockOnly}`);
  return obs;
  }

  getItemById(id: number){
    let obs = this.http.get(`${this.constants.itemsUrl}/id`);
  return obs;
  }

  //Don't subscribe here, subscribe on the component
  storeSessionData(dataType: string, data: any) {
    return this.http.post(this.constants.sessionsUrl + '/' + dataType, data, { withCredentials: true });
      //.subscribe(response => { });
  }

  getSessionData(dataType: string): any {
    return this.http.get(this.constants.sessionsUrl + '/' + dataType, { withCredentials: true });
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
      payment: order.payment,
      items: order.movies
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
/*
  get filter(): Filter {
    return this.filterObject;
  }
  get pagination(): Pagination {
    return this.paginationObject;
  }*/
}

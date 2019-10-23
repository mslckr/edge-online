import { Injectable } from '@angular/core';
import { Item } from '../model/item.model'
import { HttpClient, HttpHeaders} from '@angular/common/http';
//import { Filter, Pagination } from './configClasses.data';
import { Provider } from '../model/provider.model';
import { Order } from '../model/order.model';
import { Subject, Observable } from 'rxjs';
import { ConstantsService} from './constants.service';

class reference{
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

  //Don't subscribe here, subscribe on the component
  storeSessionData(dataType: string, data: any) {
    return this.http.post(this.constants.sessionsUrl + '/' + dataType, data, { withCredentials: true });
      //.subscribe(response => { });
  }

  getSessionData(dataType: string): any {
    return this.http.get(this.constants.sessionsUrl + '/' + dataType, { withCredentials: true });
  }

  /*
  get filter(): Filter {
    return this.filterObject;
  }
  get pagination(): Pagination {
    return this.paginationObject;
  }*/
}
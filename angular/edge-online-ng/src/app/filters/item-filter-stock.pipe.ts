import { Pipe, PipeTransform } from '@angular/core';
import { Item } from '../model/item.model';

@Pipe({
  name: 'itemFilterStock'
})
export class ItemFilterStockPipe implements PipeTransform {

  transform(items: Item[], stockOnly: boolean): any {
    if (stockOnly) {
      return items.filter(i => {
        return i.item_stock > 0;
      });
    }
    return items;
  }
}

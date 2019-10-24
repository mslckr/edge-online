import { Pipe, PipeTransform } from '@angular/core';
import { Item } from './model/item.model';

@Pipe({
  name: 'itemFilter'
})
export class ItemFilterPipe implements PipeTransform {

  transform(items: any, itemNameFilter: string): any {
    if (itemNameFilter == "") {
      return items;
    }
    
    return items.filter(i => {
      return i.name.toLowerCase().includes(itemNameFilter.toLowerCase());
    });
  }
}

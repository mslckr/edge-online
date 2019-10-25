import { Pipe, PipeTransform } from '@angular/core';
import { Item } from '../model/item.model';

@Pipe({
  name: 'itemFilterName'
})
export class ItemFilterNamePipe implements PipeTransform {

  transform(items: Item[], itemNameFilter: string): any {
    if (itemNameFilter === "") {
      return items;
    }
    return items.filter(i => {
      return i.name.toLowerCase().includes(itemNameFilter.toLowerCase());
    });
  }
}

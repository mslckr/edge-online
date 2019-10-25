import { Pipe, PipeTransform } from '@angular/core';
import { Item } from '../model/item.model';

@Pipe({
  name: 'itemFilterCategory'
})
export class ItemFilterCategoryPipe implements PipeTransform {

  transform(items: Item[], categoryFilter: string): any {
    if (categoryFilter != "") {
      return items.filter(i => {
        return i.category === categoryFilter;
      });
    }
    return items;
  }
}

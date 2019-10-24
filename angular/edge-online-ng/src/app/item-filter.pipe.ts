import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'itemFilter'
})
export class ItemFilterPipe implements PipeTransform {

  transform(items: any, itemNameFilter: string, stockOnly: boolean, providerFilter: string, categoryFilter: string): any {

    if (stockOnly) {
      items = items.filter(i => {
        return i.stock > 0;
      });
    }
    if (providerFilter != "") {
      items = items.filter(i => {
        return i.provider.name === providerFilter;
      });
    }

    if (categoryFilter != "") {
      items = items.filter(i => {
        return i.category === categoryFilter;
      });
    }

    if (itemNameFilter == "") {
      return items;
    }
    
    return items.filter(i => {
      return i.name.toLowerCase().includes(itemNameFilter.toLowerCase());
    });
  }
}

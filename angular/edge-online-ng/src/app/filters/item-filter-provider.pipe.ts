import { Pipe, PipeTransform } from '@angular/core';
import { Item } from '../model/item.model';

@Pipe({
  name: 'itemFilterProvider'
})
export class ItemFilterProviderPipe implements PipeTransform {

  transform(items: Item[], providerFilter: string): any {
    if (providerFilter != "") {
      return items.filter(i => {
        return i.provider.name === providerFilter;
      });
    }
    return items;
  }

}

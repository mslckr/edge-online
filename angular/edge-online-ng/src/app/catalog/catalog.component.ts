import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item.model';
import { DataService } from '../services/data.service'
import { Provider } from '../model/provider.model';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {

  title = "Catalog"

  items = []

    // itemId: number;
    // name: string;
    // category: string;
    // price: number;
    // image: string;
    // rating: number;
    // stock: number;
    // provider: Provider

  constructor(private dataService: DataService) { }

  currQuantity = "1";

  ngOnInit() {
    this.dataService.getAllItems().subscribe(data => {
      data.forEach(i => {
        var item = new Item();
        item.itemId = i.id;
        item.name = i.item_name;
        item.category = i.item_cat;
        item.price = i.item_price;
        item.image = i.item_img.substring(7);
        item.rating = i.item_rating;
        item.stock = i.item_stock;
        item.provider = new Provider(
          i.provider.id, 
          i.provider.prov_name, 
          i.provider.prov_addr, 
          i.provider.prov_logo.substring(7), 
          i.provider.prov_link);
        this.items.push(item);
      });
      console.log(this.items);
    });
  }

  onQuantityChanged(event: any) {
    this.currQuantity = event.target.value;
  }

  onAddClicked(itemToAdd) {
    console.log(this.currQuantity);
    console.log(itemToAdd);
  }

}

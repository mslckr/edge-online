import { Component, OnInit } from '@angular/core';
import { Item } from '../model/item.model';
import { DataService } from '../services/data.service'
import { Provider } from '../model/provider.model';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-catalog',
  templateUrl: './catalog.component.html',
  styleUrls: ['./catalog.component.css']
})
export class CatalogComponent implements OnInit {

  stockOnly = false
  title = "Catalog"
  navBarItemIndex = 1
  itemNameFilter = ""
  categoryFilter = ""
  providerFilter = ""
  items = []
  providers = new Set([])
  categories = new Set([]);

    // itemId: number;
    // name: string;
    // category: string;
    // price: number;
    // image: string;
    // rating: number;
    // stock: number;
    // provider: Provider

  constructor(private dataService: DataService, private cartService: CartService) { }

  currQuantity = "1";

  ngOnInit() {
    this.dataService.getAllItems().subscribe(data => {
      data.forEach(i => {
        var item = new Item();
        item.id = i.id;
        item.item_name = i.item_name;
        item.item_cat = i.item_cat;
        item.item_price = i.item_price;
        item.item_img = i.item_img;
        item.item_rating = i.item_rating;
        item.item_stock = i.item_stock;
        item.provider = new Provider(
          i.provider.id, 
          i.provider.prov_name, 
          i.provider.prov_addr, 
          i.provider.prov_logo, 
          i.provider.prov_link);
        this.providers.add(i.provider.prov_name);
        this.categories.add(i.item_cat);
        this.items.push(item);
      });
    });
  }

  onQuantityChanged(event: any) {
    this.currQuantity = event.target.value;
  }

  onAddClicked(itemToAdd) {
    for (var i = 0; i < parseInt(this.currQuantity); i++) {
      this.cartService.addToCart(itemToAdd);
    }
  }

  onSearchBarChanged(event: any) {
    this.itemNameFilter = event.target.value;
  }

  onStockButtonChanged(event: any) {
    this.stockOnly = !this.stockOnly;
  }

  onCategoryChange(event: any) {
    this.categoryFilter = event.target.value;
  }

  onProviderChange(event: any) {
    this.providerFilter = event.target.value;
  }

}

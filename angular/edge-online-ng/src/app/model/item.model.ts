import { Provider } from './provider.model';

export class Item {
    id: number;
    item_name: string;
    item_cat: string;
    item_price: number;
    item_img: string;
    item_rating: number;
    item_stock: number;
    provider: Provider
}
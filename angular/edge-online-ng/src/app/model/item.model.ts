import { Provider } from './provider.model';

export class Item {
    itemId: number;
    name: string;
    category: string;
    price: number;
    image: string;
    rating: number;
    stock: number;
    provider: Provider
}
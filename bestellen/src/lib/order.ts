import { IProduct } from '../components/Product/Product';
import { api } from './request';

export interface IReservation {
  table: number;
  items: IProduct[] | string;
}

export function order(table: number, cart: IProduct[]): boolean {
  if (table > 10 || table < 1) throw new Error('Your table number is invalid.');
  if (cart.length <= 0) throw new Error("You haven't chosen anything to order.");

  api.createReservation({ table, items: cart });

  return false;
}

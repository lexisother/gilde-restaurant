import { IProduct } from '../components/Product/Product';
import { IReservation } from './order';

const BASE_URL = 'https://gdos-api.alyxia.dev';
export const api = {
  getProducts: (url = `${BASE_URL}/products`) => request<IProduct[]>(url),

  createReservation: (body: IReservation, url = `${BASE_URL}/reservations/create`) => {
    body.items = body.items.toString();
    // @ts-expect-error The fetch API is not typed properly.
    request<IReservation>(url, { method: 'POST', body });
  },
};

export async function request<Res>(url: string, config?: RequestInit): Promise<Res> {
  const response = await fetch(url, config);
  if (!response.ok) throw new Error('Something went wrong!');
  return response.json();
}

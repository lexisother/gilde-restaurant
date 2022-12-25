import { IProduct } from '../../components/Product/Product';
import { PayloadAction, createSlice } from '@reduxjs/toolkit';
import { RootState } from '../../app/store';
import { Storage } from '../../lib/localStorage';

export interface CartState {
  items: IProduct[];
}

const initialState: CartState = {
  items: [],
};
const cart = Storage.get<IProduct[]>('cart');
if (cart) initialState.items = cart;

export const cartSlice = createSlice({
  name: 'cart',
  initialState,
  reducers: {
    add: (state, action: PayloadAction<IProduct>) => {
      state.items.push(action.payload);
    },
    remove: (state, action: PayloadAction<number>) => {
      state.items.splice(action.payload, 1);
    },
  },
});

export function addToCart(prod: IProduct): void {
  let currBasket = Storage.get<IProduct[]>('cart') ?? [];
  Storage.set('cart', [...currBasket, prod]);
}
export function removeFromCart(item: number): void {
  let currBasket = Storage.get<IProduct[]>('cart');
  currBasket.splice(item, 1);
  Storage.set('cart', currBasket);
}

export const { add, remove } = cartSlice.actions;
export const selectItems = (state: RootState): IProduct[] => state.cart.items;
export default cartSlice.reducer;

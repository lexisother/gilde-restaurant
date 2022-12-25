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
  },
});

export const { add } = cartSlice.actions;
export const selectItems = (state: RootState): IProduct[] => state.cart.items;
export default cartSlice.reducer;

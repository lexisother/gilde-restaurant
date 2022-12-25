import { IProduct } from '../../components/Product/Product';
import { PayloadAction, createSlice } from '@reduxjs/toolkit';
import { RootState } from '../../app/store';

export interface CartState {
  items: IProduct[];
}

const initialState: CartState = {
  items: [],
};

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

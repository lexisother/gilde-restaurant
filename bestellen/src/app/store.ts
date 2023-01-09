import { Action, ThunkAction, configureStore } from '@reduxjs/toolkit';
import cartReducer from '../features/cart/cartSlice';
import noticeReducer from '../features/notice/noticeSlice';

export const store = configureStore({
  reducer: {
    cart: cartReducer,
    notice: noticeReducer,
  },
});

export type AppDispatch = typeof store.dispatch;
export type RootState = ReturnType<typeof store.getState>;
export type AppThunk<ReturnType = void> = ThunkAction<
  ReturnType,
  RootState,
  unknown,
  Action<string>
>;

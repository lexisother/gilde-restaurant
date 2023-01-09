import { PayloadAction, createSlice } from '@reduxjs/toolkit';
import { RootState } from '../../app/store';

// type NoticeType = 'info' | 'warning' | 'error';
export interface NoticeState {
  message: string;
  // type: NoticeType;
  hidden: boolean;
}

const initialState: NoticeState = {
  message: '',
  // type: 'info',
  hidden: true,
};

export const noticeSlice = createSlice({
  name: 'notice',
  initialState,
  reducers: {
    setMessage: (state, action: PayloadAction<string>) => {
      state.message = action.payload;
    },
    // setType: (state, action: PayloadAction<NoticeType>) => {
    //   state.type = action.payload;
    // },
    setHidden: (state, action: PayloadAction<boolean>) => {
      state.hidden = action.payload;
    },
  },
});

export const { setMessage, /*setType,*/ setHidden } = noticeSlice.actions;
export const selectMessage = (state: RootState): string => state.notice.message;
export const selectHidden = (state: RootState): boolean => state.notice.hidden;
export default noticeSlice.reducer;

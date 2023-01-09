import generalStyles from '../styles/General.module.scss';
import styles from '../styles/PurchaseList.module.scss';
import { useAppDispatch, useAppSelector } from '../app/hooks';
import { remove, removeFromCart, selectItems } from '../features/cart/cartSlice';
import { RxCross1 } from 'react-icons/rx';
import { BiPurchaseTag } from 'react-icons/bi';
import { order } from '../lib/order';
import { Storage } from '../lib/localStorage';
import { IProduct } from './Product/Product';
import { setHidden, setMessage } from "../features/notice/noticeSlice";

// TODO: STYLE CLEANUP!!!!
export default function PurchaseList(): JSX.Element {
  const items = useAppSelector(selectItems);
  const dispatch = useAppDispatch();
  return (
    <div className={styles.purchaseContainer}>
      <h3 style={{ marginTop: '0' }}>Bestelling</h3>
      <div>
        {items.length > 0 ? (
          items.map((item, i) => (
            <li className={styles.cartItem} key={i}>
              {item.name}
              <a
                onClick={() => {
                  dispatch(remove(i));
                  removeFromCart(i);
                }}
                className={generalStyles.button}>
                <RxCross1 />
              </a>
            </li>
          ))
        ) : (
          <i>Niks te zien hier...</i>
        )}
      </div>
      <button onClick={() => {
        dispatch(setMessage("cock"))
        dispatch(setHidden(false))
      }}>cock</button>
      <div style={{ display: 'flex', gap: '1rem' }}>
        <input
          type="number"
          min={1}
          max={10}
          defaultValue={1}
          className={generalStyles.inputField}
        />
        <a
          onClick={() =>
            order(
              document.querySelector('input')!.value as unknown as number,
              Storage.get<IProduct[]>('cart'),
            )
          }
          style={{ justifyContent: 'center' }}
          className={generalStyles.button}>
          <BiPurchaseTag /> Bestellen
        </a>
      </div>
    </div>
  );
}

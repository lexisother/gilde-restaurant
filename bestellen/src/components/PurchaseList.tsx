import generalStyles from '../styles/General.module.scss';
import styles from '../styles/PurchaseList.module.scss';
import { useAppDispatch, useAppSelector } from '../app/hooks';
import { remove, removeFromCart, selectItems } from '../features/cart/cartSlice';
import { RxCross1 } from 'react-icons/rx';
import { BiPurchaseTag } from 'react-icons/bi';

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
      <a style={{ justifyContent: 'center' }} className={generalStyles.button}>
        <BiPurchaseTag /> Bestellen
      </a>
    </div>
  );
}

import styles from '../styles/PurchaseList.module.scss';
import { useAppSelector } from '../app/hooks';
import { selectItems } from '../features/cart/cartSlice';

export default function PurchaseList(): JSX.Element {
  const items = useAppSelector(selectItems);
  return <div className={styles.purchaseContainer}>{items.length}</div>;
}

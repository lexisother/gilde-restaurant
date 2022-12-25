import styles from '../../styles/Product.module.scss';
import MetaItem from './MetaItem';
import { FaEuroSign, FaShoppingBasket } from 'react-icons/fa';
import { Storage } from '../../lib/localStorage';
import { useAppDispatch } from '../../app/hooks';
import { add } from '../../features/cart/cartSlice';

export interface IProduct {
  id: number;
  name: string;
  description: string;
  price: number;
  spanish: boolean;
  warm: boolean;
  cold: boolean;
  vega: boolean;
}

interface ProductProps {
  data: IProduct;
}
export default function Product({ data }: ProductProps): JSX.Element {
  const dispatch = useAppDispatch();
  return (
    <div className={styles.product}>
      <img src="https://placekitten.com/231/195" />
      <div className={styles.productData}>
        <div className={styles.productDataText}>
          <div className={styles.productName}>{data.name}</div>
          <div className={styles.productDesc}>{data.description}</div>
        </div>
        <div className={styles.productDataMeta}>
          <MetaItem Icon={FaEuroSign} text={data.price.toString()} />
          <div className={styles.productTypes}>[icon list]</div>
        </div>
      </div>
      <a onClick={() => dispatch(add(data))} className={styles.addButton}>
        <FaShoppingBasket /> <div>Toevoegen aan bestelling</div>
      </a>
    </div>
  );
}

function addToBasket(prod: IProduct): void {
  let currBasket = Storage.get<IProduct[]>('cart') ?? [];
  Storage.set('cart', [...currBasket, prod]);
}

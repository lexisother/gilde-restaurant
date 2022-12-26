import generalStyles from '../../styles/General.module.scss';
import styles from '../../styles/Product.module.scss';
import MetaItem from './MetaItem';
import { FaEuroSign, FaShoppingBasket } from 'react-icons/fa';
import { useAppDispatch } from '../../app/hooks';
import { add, addToCart } from '../../features/cart/cartSlice';
import warm from '../../res/img/warm.svg';
import cold from '../../res/img/cold.svg';
import spanish from '../../res/img/spain.png';
import vega from '../../res/img/vega.png';

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
          <div className={styles.productTypes}>
            {data.warm && <img className={styles.icon} src={warm} alt="warm" />}
            {data.cold && <img className={styles.icon} src={cold} alt="cold" />}
            {data.spanish && <img className={styles.icon} src={spanish} alt="spanish" />}
            {data.vega && <img className={styles.icon} src={vega} alt="vega" />}
          </div>
        </div>
      </div>
      <a
        onClick={() => {
          dispatch(add(data));
          addToCart(data);
        }}
        style={{
          marginRight: '1rem',
          marginBottom: '1rem',
        }}
        className={generalStyles.button}>
        <FaShoppingBasket /> <div>Toevoegen aan bestelling</div>
      </a>
    </div>
  );
}

import { IconType } from 'react-icons';
import styles from '../../styles/Product.module.scss';

interface MetaItemProps {
  Icon: IconType;
  text: string;
}
export default function MetaItem({ Icon, text }: MetaItemProps): JSX.Element {
  return (
    <div className={styles.metaItem}>
      <Icon />
      <div>{text}</div>
    </div>
  );
}

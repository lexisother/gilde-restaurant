import { useEffect, useState } from 'react';
import { api } from '../lib/request';
import Product, { IProduct } from './Product/Product';

export default function ProductList(): JSX.Element {
  const [data, setData] = useState<IProduct[] | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    api
      .getProducts()
      .then((data) => {
        setData(data);
        setError(null);
      })
      .catch((err) => {
        setError(err.message);
        setData(null);
      })
      .finally(() => setLoading(false));
  }, []);

  return (
    <div className="products">
      {loading && <div>Loading...</div>}
      {error && <div>{`There was a problem fetching the products.\n${error}`}</div>}
      <ul>
        {data?.map((prod) => (
          <Product key={prod.id} data={prod} />
        ))}
      </ul>
    </div>
  );
}

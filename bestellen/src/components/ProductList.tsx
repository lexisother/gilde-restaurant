import { useEffect, useState } from 'react';
import Product, { IProduct } from './Product/Product';

export default function ProductList(): JSX.Element {
  const [data, setData] = useState<IProduct[] | null>(null);
  const [loading, setLoading] = useState<boolean>(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    fetch('https://gdos-api.alyxia.dev/products')
      .then((res) => {
        if (!res.ok) throw new Error('something went wrong!');
        return res.json();
      })
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
          <Product data={prod} />
        ))}
      </ul>
    </div>
  );
}

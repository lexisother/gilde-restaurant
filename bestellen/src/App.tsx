import ProductList from './components/ProductList';
import PurchaseList from './components/PurchaseList';
import NoticeContainer from './components/NoticeContainer';
import './App.scss';

export default function App(): JSX.Element {
  return (
    <>
      <NoticeContainer />
      <div className="app-container">
        <ProductList />
        <PurchaseList />
      </div>
    </>
  );
}

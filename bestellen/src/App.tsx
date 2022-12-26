import React from 'react';
import ProductList from './components/ProductList';
import PurchaseList from './components/PurchaseList';
import './App.scss';

export default function App(): JSX.Element {
  return (
    <div className="app-container">
      <ProductList />
      <PurchaseList />
    </div>
  );
}

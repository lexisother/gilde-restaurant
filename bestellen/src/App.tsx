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
  // return (
  //   <div className="App">
  //     <header className="App-header">
  //       <img src={logo} className="App-logo" alt="logo" />
  //       <p>
  //         Edit <code>src/App.tsx</code> and save to reload.
  //       </p>
  //       <a
  //         className="App-link"
  //         href="https://reactjs.org"
  //         target="_blank"
  //         rel="noopener noreferrer"
  //       >
  //         Learn React
  //       </a>
  //     </header>
  //   </div>
  // );
}

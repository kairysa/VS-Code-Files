import React, {useState} from 'react';
import ProductForm from '../components/ProductForm';
import ProductList from '../components/ProductList';

const Main = (props) => {
  const [productList, setProductList] = useState([]);

  const removeFromDom = productId => {
    setProductList(productList.filter(product => product._id !== productId));
  }

  return (
    <div>
      <ProductForm productList={productList} setProductList={setProductList} />
      <ProductList productList={productList} setProductList={setProductList} removeFromDom={removeFromDom}/>
    </div>
  )
}

export default Main;
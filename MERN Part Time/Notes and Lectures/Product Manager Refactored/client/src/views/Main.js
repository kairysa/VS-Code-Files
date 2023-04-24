import React, {useState, useEffect} from 'react';
import ProductForm from '../components/ProductForm';
import ProductList from '../components/ProductList';
import axios from 'axios';

const Main = (props) => {
  const [productList, setProductList] = useState([]);
  const [errors, setErrors] = useState([]);

  useEffect(()=> {
    axios.get("http://localhost:8000/api/")
      .then((res)=>{
        console.log(res.data);
        setProductList(res.data.products);
      })
      .catch((err)=>{
        console.log(err);
      });
  }, []);

  const createProduct = (productParam) => {
    axios.post('http://localhost:8000/api/product', productParam)
    .then(res=> {
      console.log(res);
      console.log(res.data);
      // NEW - SET THE PRODUCT LIST TO THE NEW LIST WITH POSTED OBJECT - this will re-render the page automatically
      setProductList([...productList, res.data]);
    })
    .catch(err=>{setErrors(err.response.data.errors)})
  }

  const removeFromDom = productId => {
    setProductList(productList.filter(product => product._id !== productId));
  }

  return (
    <div>
      <h1>Product Manager</h1>
      <ProductForm onSubmitProp={createProduct} initialProductName="" initialPrice="" initialDescription="" errors={errors}/>
      <ProductList productList={productList} removeFromDom={removeFromDom}/>
    </div>
  )
}

export default Main;
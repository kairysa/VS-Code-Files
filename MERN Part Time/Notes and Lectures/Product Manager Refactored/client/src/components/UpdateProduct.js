import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {useNavigate, useParams, Link} from 'react-router-dom';
import ProductForm from '../components/ProductForm';
import DeleteButton from '../components/DeleteButton';

const UpdateProduct = (props) => {
  const {id} = useParams();

  const [errors, setErrors] = useState([]);
  const [product, setProduct] = useState({});
  const [loaded, setLoaded] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    axios.get('http://localhost:8000/api/' + id)
      .then(res => {
        setProduct(res.data);
        setLoaded(true);
      })
      .catch((err)=>{
        console.log(err);
      });
  }, []);

  const updateProduct = (productParam) => {
    axios.put('http://localhost:8000/api/' + id, productParam)
      .then(res => {
        console.log(res);
        navigate("/");
      })
      .catch(err=>{setErrors(err.response.data.errors)})
  }

  return (
    <div>
      <h1 className="mt-3">Update Product</h1>
    { loaded && <ProductForm 
    onSubmitProp={updateProduct} 
    initialProductName={product.productName} 
    initialPrice={product.price} 
    initialDescription={product.description}
    errors={errors} />
    }
      <div className="d-flex justify-content-around mt-3">
        <Link to="/">Home</Link>
        <DeleteButton 
        productId = {product._id}
        successCallback={() => navigate('/')}/>
      </div>
    </div>
  )
}

export default UpdateProduct;
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {useParams, Link} from 'react-router-dom';

const OneProduct = (props) => {
  const [product, setProduct] = useState({});
  const {id} = useParams();

  useEffect(() => {
    axios.get('http://localhost:8000/api/' + id)
      .then(res => {
        console.log(res.data);
        setProduct(res.data);
      })
      .catch((err)=>{
        console.log(err);
      });
  }, []);

  return (
    <div>
      <table className="table table-bordered text-white mt-3">
        <thead>
          <tr>
            <th>Product Name</th>
            <th>Price</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>{product.productName}</td>
            <td>${product.price}</td>
            <td>{product.description}</td>
          </tr>
        </tbody>
      </table>
      <Link to="/">Home</Link>
    </div>
  )
}

export default OneProduct;
import React, {useState, useEffect} from 'react';
import axios from 'axios'
import {Link} from 'react-router-dom';

const ProductList = (props) => {
  const {productList, setProductList} = props;
  const {removeFromDom, product, setProduct} = props;

  const deleteProduct = (id) => {
    axios.delete('http://localhost:8000/api/' + id)
      .then(res => {
        removeFromDom(id)
      })
      .catch((err)=>{
        console.log(err);
      });
  }

  useEffect(()=> {
    axios.get("http://localhost:8000/api")
      .then((res)=>{
        console.log(res.data);
        setProductList(res.data.products);
      })
      .catch((err)=>{
        console.log(err);
      });
  }, []);

  return (
    <table className="table text-white mt-5 table-bordered">
      <thead>
        <tr>
          <th>All Products</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {
          productList.map((product, index)=>{
            return <tr key={index}>
              <td><Link to={`/${product._id}`}>{product.productName}</Link></td>
              <td>
                <Link to={`/edit/${product._id}`}>Edit</Link> | 
                <button onClick={(e)=>{deleteProduct(product._id)}} className="btn btn-link m-0 p-0">Delete</button>
              </td>
            </tr>
          })
        }
      </tbody>
    </table>
  )
}

export default ProductList;
import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {useNavigate, useParams, Link} from 'react-router-dom';

const UpdateProduct = (props) => {
  const {id} = useParams();

  const [productName, setProductName] = useState();
  const [price, setPrice] = useState();
  const [description, setDescription] = useState();
  const navigate = useNavigate();

  const deleteProduct = (id) => {
    axios.delete('http://localhost:8000/api/' + id)
      .then(res => {
        console.log(res)
      })
      .catch((err)=>{
        console.log(err);
      });
  }

  useEffect(() => {
    axios.get('http://localhost:8000/api/' + id)
      .then(res => {
        setProductName(res.data.productName);
        setPrice(res.data.price);
        setDescription(res.data.description);
      })
      .catch((err)=>{
        console.log(err);
      });
  }, []);

  const updateProduct = (e) => {
    e.preventDefault();
    axios.put('http://localhost:8000/api/' + id, {
      productName,
      price,
      description
    })
      .then(res => {
        console.log(res);
        navigate("/");
      })
      .catch((err)=>{
        console.log(err);
      });
  }

  return (
    <div>
      <h1 className="mt-3">Update Product</h1>
      <form onSubmit={updateProduct} className="form-group d-flex flex-column">
        
        <label>Product Name:</label>
        <input type="text"
        name="productName"
        value={productName}
        onChange={(e) => {setProductName(e.target.value)}}
        className="form-control"/>

        <label className="mt-3">Price:</label>
        <input type="number"
        name="price"
        value={price}
        onChange={(e) => {setPrice(e.target.value)}}
        className="form-control"/>

        <label className="mt-3">Description:</label>
        <textarea 
          name="description" 
          onChange={(e) => {setDescription(e.target.value)}}
          className="form-control"
          value={description}>
        </textarea>

        <input type="submit" className="btn btn-primary mt-3" value="Submit Changes"/>
      </form>
      <div className="d-flex justify-content-around mt-3">
        <Link to="/">Home</Link>
        <Link to="/" onClick={(e)=>{deleteProduct(id)}} className="btn btn-link m-0 p-0">Delete</Link>
      </div>
    </div>
  )
}

export default UpdateProduct;
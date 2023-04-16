import React, { useState } from 'react'
import axios from 'axios';

const ProductForm = (props) => {
  const {productList, setProductList} = props; // be sure to add this when rendering our list of products
  const [productName, setProductName] = useState("");
  const [price, setPrice] = useState(0);
  const [description, setDescription] = useState("");

  const submitHandler = (e) => {
    e.preventDefault();

    axios.post('http://localhost:8000/api/product', {
      productName,
      price,
      description
    })
    .then(res=> {
      console.log(res);
      console.log(res.data);
      // NEW - SET THE PRODUCT LIST TO THE NEW LIST WITH POSTED OBJECT - this will re-render the page automatically
      setProductList([...productList, res.data]);
    })
    .catch(err=>console.log(err))
  }
  return(
    <div>
      <h1>Product Manager</h1>
      <form className="d-flex flex-column form-group" onSubmit={submitHandler}>
        <label>Product Name:</label>
        <input type="text" className="form-control" onChange={(e)=>setProductName(e.target.value)}/>
        <label className="mt-3">Price:</label>
        <input type="number" className="form-control" step=".01"onChange={(e)=>setPrice(e.target.value)}/>
        <label className="mt-3">Description:</label>
        <textarea className="form-control" onChange={(e)=>setDescription(e.target.value)}></textarea>
        <input type="submit" className="btn btn-primary mt-3" value="Create"/>
      </form>
    </div>
  )
}

export default ProductForm;
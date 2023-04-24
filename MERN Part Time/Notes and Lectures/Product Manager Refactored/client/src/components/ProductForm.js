import React, { useState } from 'react';

const ProductForm = (props) => {
  const { initialProductName, initialPrice, initialDescription, onSubmitProp, errors} = props; // be sure to add this when rendering our list of products
  const [productName, setProductName] = useState(initialProductName);
  const [price, setPrice] = useState(initialPrice);
  const [description, setDescription] = useState(initialDescription);

  const onSubmitHandler = e => {
    e.preventDefault();
    onSubmitProp({productName, price, description})
  }

  return(
    <div>
      <form className="d-flex flex-column form-group" onSubmit={onSubmitHandler}>
        <label>Product Name:</label>
        <input type="text" className="form-control" onChange={(e)=>setProductName(e.target.value)} value={productName}/>
        { errors.productName ?
          <p className="text-danger m-0">{errors.productName.message}</p> 
          : null
        }
        <label className="mt-3">Price:</label>
        <input type="number" className="form-control" step=".01"onChange={(e)=>setPrice(e.target.value)} value={price}/>
        { errors.price ?
          <p className="text-danger m-0">{errors.price.message}</p> 
          : null
        }
        <label className="mt-3">Description:</label>
        <textarea className="form-control" onChange={(e)=>setDescription(e.target.value)} value={description}></textarea>
        { errors.description ?
          <p className="text-danger m-0">{errors.description.message}</p> 
          : null
        }
        <input type="submit" className="btn btn-primary mt-3" value="Submit"/>
      </form>
    </div>
  )
}

export default ProductForm;
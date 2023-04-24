import React from 'react';
import axios from 'axios';

const DeleteButton = (props) => {
  const {productId, successCallback} = props;
  const deleteProduct = e => {
    axios.delete('http://localhost:8000/api/' + productId)
      .then(res => {
        console.log(res)
        successCallback();
      })
      .catch((err)=>{
        console.log(err);
      });
  }
  return (
    <button onClick={deleteProduct} className="btn btn-link m-0 p-0">
      Delete
    </button>
  )
}

export default DeleteButton;
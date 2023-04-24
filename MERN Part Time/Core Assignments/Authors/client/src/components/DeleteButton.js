import React from 'react';
import axios from 'axios';

const DeleteButton = (props) => {
  const {authorId, successCallback} = props;
  const deleteAuthor = e => {
    axios.delete('http://localhost:8000/api/' + authorId)
      .then(res => {
        console.log(res)
        successCallback();
      })
      .catch((err)=>{
        console.log(err);
      });
  }
  return (
    <button onClick={deleteAuthor} className="btn btn-link m-0 p-0">
      Delete
    </button>
  )
}

export default DeleteButton;
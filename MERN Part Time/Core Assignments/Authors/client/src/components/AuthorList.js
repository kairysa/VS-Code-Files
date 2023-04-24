import React, {useState, useEffect} from 'react';
import axios from 'axios'
import {Link} from 'react-router-dom';
import DeleteButton from './DeleteButton';

const AuthorList = (props) => {
  const {authorList, setAuthorList} = props;
  const {removeFromDom, author, setAuthor} = props;

  useEffect(()=> {
    axios.get("http://localhost:8000/api")
      .then((res)=>{
        console.log(res.data);
        setAuthorList(res.data.authors);
      })
      .catch((err)=>{
        console.log(err);
      });
  }, []);

  return (
    <table className="table text-white mt-5 table-bordered">
      <thead>
        <tr>
          <th>All authors</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        {
          authorList.map((author, index)=>{
            return <tr key={index}>
              <td><Link to={`/${author._id}`}>{author.name}</Link></td>
              <td>
                <Link to={`/edit/${author._id}`}>Edit</Link> | 
                <DeleteButton authorId={author._id} successCallback={() =>removeFromDom(author._id)}/>
              </td>
            </tr>
          })
        }
      </tbody>
    </table>
  )
}

export default AuthorList;
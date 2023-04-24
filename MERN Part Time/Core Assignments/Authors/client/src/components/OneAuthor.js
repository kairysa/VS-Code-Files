import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {useParams, Link} from 'react-router-dom';

const OneAuthor = (props) => {
  const [author, setAuthor] = useState({});
  const {id} = useParams();

  useEffect(() => {
    axios.get('http://localhost:8000/api/' + id)
      .then(res => {
        console.log(res.data);
        setAuthor(res.data);
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
            <th>Author Name</th>
            <td>{author.name}</td>
          </tr>
        </thead>
      </table>
      <Link to="/">Home</Link>
    </div>
  )
}

export default OneAuthor;
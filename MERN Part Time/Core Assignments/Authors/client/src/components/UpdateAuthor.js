import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {useNavigate, useParams, Link} from 'react-router-dom';
import AuthorForm from '../components/AuthorForm';
import DeleteButton from '../components/DeleteButton';

const UpdateAuthor = (props) => {
  const {id} = useParams();

  const [errors, setErrors] = useState([]);
  const [author, setAuthor] = useState({});
  const [loaded, setLoaded] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    axios.get('http://localhost:8000/api/' + id)
      .then(res => {
        setAuthor(res.data);
        setLoaded(true);
        console.log(res);
      })
      .catch((err)=>{
        console.log(err);
      });
  }, []);

  const updateAuthor = (authorParam) => {
    axios.put('http://localhost:8000/api/' + id, authorParam)
      .then(res => {
        console.log(res);
        navigate("/");
      })
      .catch(err=>{setErrors(err.response.data.errors)})
  }

  return (
    <div>
      <h1 className="mt-3">Update Author</h1>
    { loaded && <AuthorForm 
    onSubmitProp={updateAuthor} 
    initialName={author.name} 
    errors={errors} />
    }
      <div className="d-flex justify-content-around mt-3">
        <Link to="/">Home</Link>
        <DeleteButton 
        authorId = {author._id}
        successCallback={() => navigate('/')}/>
      </div>
    </div>
  )
}

export default UpdateAuthor;
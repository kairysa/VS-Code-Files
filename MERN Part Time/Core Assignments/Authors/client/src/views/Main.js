import React, {useState, useEffect} from 'react';
import AuthorForm from '../components/AuthorForm';
import AuthorList from '../components/AuthorList';
import axios from 'axios';

const Main = (props) => {
  const [authorList, setAuthorList] = useState([]);
  const [errors, setErrors] = useState([]);

  useEffect(()=> {
    axios.get("http://localhost:8000/api/")
      .then((res)=>{
        console.log(res.data);
        setAuthorList(res.data.authors);
      })
      .catch((err)=>{
        console.log(err);
      });
  }, []);

  const createAuthor = (authorParam) => {
    axios.post('http://localhost:8000/api/author', authorParam)
    .then(res=> {
      console.log(res);
      console.log(res.data);
      // NEW - SET THE author LIST TO THE NEW LIST WITH POSTED OBJECT - this will re-render the page automatically
      setAuthorList([...authorList, res.data]);
    })
    .catch(err=>{setErrors(err.response.data.errors)})
  }

  const removeFromDom = authorId => {
    setAuthorList(authorList.filter(author => author._id !== authorId));
  }

  return (
    <div>
      <h1>Favorite Authors</h1>
      <AuthorForm onSubmitProp={createAuthor} initialName="" errors={errors}/>
      <AuthorList authorList={authorList} removeFromDom={removeFromDom}/>
    </div>
  )
}

export default Main;
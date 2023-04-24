import React, {useState} from 'react';

const AuthorForm = (props) => {
  const {initialName, errors, onSubmitProp} = props;
  const [name, setName] = useState(initialName);

  const onSubmitHandler = e => {
    e.preventDefault();
    onSubmitProp({name})
  }

  return(
    <div>
      <form className="d-flex flex-column form-group" onSubmit={onSubmitHandler}>
        <label>Author Name:</label>
        <input type="text" className="form-control" onChange={(e)=>setName(e.target.value)} value={name}/>
        { errors.name ?
          <p className="text-danger m-0">{errors.name.message}</p> 
          : null
        }
        <input type="submit" className="btn btn-primary mt-3" value="Submit"/>
      </form>
    </div>
  )
}

export default AuthorForm;
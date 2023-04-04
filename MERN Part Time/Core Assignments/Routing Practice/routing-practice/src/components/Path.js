import React from 'react';
import {useParams} from "react-router-dom";

const Path = (props) => {
  const {word} = useParams();
  const {color} = useParams();
  const {backgroundColor} = useParams();
  
  return (
    <div>
      {isNaN(+word) ?
        <h1 style={{color: color, backgroundColor: backgroundColor}}>The word is: {word}</h1> :
        <h1 style={{color: color, backgroundColor: backgroundColor}}>The number is: {word}</h1>
      }
    </div>
  )
}

export default Path;
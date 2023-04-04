import React, {useEffect} from 'react';
import {useParams} from "react-router-dom";
import axios from 'axios';

const ChosenOption = (props) => {
  const {starWarsList, setStarWarsList} = props;
  const {type} = useParams();
  const {number} = useParams();
  const option = starWarsList[number];
  useEffect(() => {
    axios.get('https://swapi.dev/')      
      .then(response => {
        setStarWarsList(response.data.results);
    })      
      .catch((err) => {
        alert("These aren't the droids you are looking for");
        console.log(err);
    })
  }, [])
  return (
    <div>
      <h1>
        {option.name}
      </h1>
    </div>
  )
}

export default ChosenOption;
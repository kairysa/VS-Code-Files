import React, { useState } from 'react';
const PersonCard = (props) => {
    const [ age, setAge ] = useState(props.age);
    return(
        <div>
            <h1 style={{color:"red"}}>{ props.firstName } { props.lastName }</h1>
            <p>Age: {age}</p>
            <p>Hair Color: {props.hairColor}</p>
            <button className = "btn btn-primary" onClick = { (event) => setAge(age + 1)}>Birthday!</button>
        </div>
    );
}
export default PersonCard;


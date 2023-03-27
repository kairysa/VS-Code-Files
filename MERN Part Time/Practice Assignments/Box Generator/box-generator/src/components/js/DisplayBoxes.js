import React, {useState} from 'react';
import "../css/style.css";

const DisplayBoxes = (props) => {
    const {colorArray, setColorArray} = props;

    console.log(Array.isArray(colorArray));
    console.log(colorArray);
    return (
        <div className="d-flex">
            {
                colorArray.map((color, index) => (
                    <div key={index} style={{backgroundColor: color}} className="box">
                    </div>
                ))
            }
        </div>
    )
}

export default DisplayBoxes
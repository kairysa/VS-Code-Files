import React, { useState } from 'react';

const Box = (props) => {
    console.log(props)
    const {colorArray, setColorArray} = props;
    const [boxColor, setBoxColor] = useState("");

    const handleSubmit  = (e) => {
        e.preventDefault();
        setColorArray([...colorArray, boxColor]);
    }
    return (
        <div className="d-flex flex-column align-items-center">
            <h1 className="p-3">Boxes!</h1>
            <form onSubmit={handleSubmit} className="form-group w-75 d-flex">
                <label htmlFor="color">Color:</label>
                <input type="text" name="color" className="form-control" onChange={ (e) => setBoxColor(e.target.value)}/>
                <input type="submit" value="Add" className="btn btn-primary"/>
            </form>
        </div>
    )
}

export default Box;
import React from 'react';
import '../css/style.css';

const Main = (props) => {
    return (
        <div className="main d-flex flex-column">
            {props.children}
        </div>
    )
}

export default Main;
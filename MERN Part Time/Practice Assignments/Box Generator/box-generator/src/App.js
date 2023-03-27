import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';
import Box from './/components/js/Box.js';
import DisplayBoxes from './/components/js/DisplayBoxes.js';

function App() {
  const [colorArray, setColorArray] = useState([]);

  return (
    <div className="App">
      <Box colorArray = {colorArray} setColorArray = {setColorArray}/>
      <DisplayBoxes  colorArray = {colorArray} setColorArray = {setColorArray}/>
    </div>
  );
}

export default App;

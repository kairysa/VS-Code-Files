import React, {useState, useEffect} from 'react';
import {BrowserRouter, Routes, Route, useParams} from 'react-router-dom';
import './App.css';
import ChosenOption from './components/ChosenOption';
import Home from './components/Home';

function App() {
  const [starWarsList, setStarWarsList] = useState([]);
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/:type/:number" starWarsList={starWarsList} setStarWarsList={setStarWarsList} element={<ChosenOption/>}/>
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;

import React from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Main from './views/Main';
import OneProduct from './components/OneProduct';
import UpdateProduct from './components/UpdateProduct';
import './App.css';

function App() {

  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route element={<Main/>} path="/" default/>
          <Route element={<OneProduct/>} path="/:id" />
          <Route element={<UpdateProduct/>} path="/edit/:id"/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

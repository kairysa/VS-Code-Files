import React from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import Main from './views/Main';
import OneAuthor from './components/OneAuthor';
import UpdateAuthor from './components/UpdateAuthor';
import './App.css';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route element={<Main/>} path="/" default/>
          <Route element={<OneAuthor/>} path="/:id"/>
          <Route element={<UpdateAuthor/>} path="/edit/:id"/>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;

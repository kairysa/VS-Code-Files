import React from 'react';
import './App.css';
import Header from './components/js/Header';
import Navigation from './components/js/Navigation';
import Main from './components/js/Main';
import Subcontent from './components/js/Subcontent';
import Advertisement from './components/js/Advertisement';

function App() {
  return (
    <div className="App container-fluid p-3 d-flex flex-column">
      <Header/>
      <div class="d-flex mt-3">
        <Navigation/>
        <Main>
          <Subcontent/>
          <Advertisement/>
        </Main>
      </div>
    </div>
  );
}

export default App;

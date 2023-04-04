import {BrowserRouter, Routes, Route} from 'react-router-dom';
import './App.css';
import Home from './components/Home';
import Path from './components/Path';

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/home" element={<Home/>}/>
          <Route path="/:word" element={<Path/>}/>
          <Route path="/:word/:color" element={<Path/>}/>
          <Route path="/:word/:color/:backgroundColor" element={<Path/>}/>
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;

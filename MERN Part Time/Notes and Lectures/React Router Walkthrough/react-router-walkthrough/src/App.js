import './App.css';
import {BrowserRouter, Routes, Route, Link, useNavigate} from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';


// const Home = (props) => {
//   return(
//     <div>
//       <h1 style={{color:"red"}}>
//         Home Component
//       </h1>
//       <Link to={"/about"}>Go to About</Link>
//     </div>
//   )
// }

// const About = (props) => {
//   return(
//     <div>
//       <h1 style={{color:"blue"}}>
//         About Component
//       </h1>
//       <Link to={"/"}>Go to Home</Link>
//     </div>
//   )
// }

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/about" element={<About />}/>
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;

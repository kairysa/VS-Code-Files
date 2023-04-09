import './App.css';
import axios from 'axios';
import {useEffect, useState} from 'react';

function App() {
  const [tvShowList, setTvShowList] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8000/api/allshows')
      .then((response) => {
        console.log(response);
        setTvShowList(response.data.shows);
      })
      .catch((err) => {
        console.log(err);
      })
  }, [])
  return (
    <div className="App">
      <h1>Welcome to our TV Show app</h1>
    </div>
  );
}

export default App;

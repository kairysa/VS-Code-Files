import React from 'react';
import './App.css';
import PersonCard from './components/PersonCard';

function App() {
  return (
    <div className="container d-flex flex-column align-items-center p-3">
      <PersonCard />
    </div>
    
  );
}

export default App;


// Using JSX, we can render any HTML tags within the App function. We aren't able to put anything we want, however.
// JSX Expressions must have one Parent element, without it, we would get an error.

// IMPORTANT NOTE: When using HTML class attribute, we need to use the className in JSX instead of simply class in HTML. - example shown in the div tag above.
// similarly, instead of using "for" for labels, we'd use htmlFor
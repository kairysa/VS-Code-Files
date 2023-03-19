import React from 'react';
import './App.css';
import PersonCard from './components/PersonCard';

function App() {
  return (
    <div className="container d-flex flex-column align-items-center p-3">
      <h1>Hello Dojo!</h1>
      <h2>Things I need to do:</h2>
      <ul className="list-group">
        <li>Learn React</li>
        <li>Climb Mt. Everest</li>
        <li>Run a marathon</li>
        <li>Feed the dogs</li>
      </ul>
      <div>
        <PersonCard 
          firstName = {"Noah"}
          lastName = {"Gardner"}
          age = {23}
          hairColor = {"Black"}
        />
        <PersonCard 
          firstName = {"Akira"}
          lastName = {"Cole"}
          age = {23}
          hairColor = {"Light Brown"}
        />
        <PersonCard 
          firstName = {"Chase"}
          lastName = {"Klaesges"}
          age = {23}
          hairColor = {"Blonde"}
        />
        <PersonCard 
          firstName = {"Jake"}
          lastName = {"Dagenais"}
          age = {23}
          hairColor = {"Black"}
        />
      </div>
    </div>
  );
}

export default App;


// Using JSX, we can render any HTML tags within the App function. We aren't able to put anything we want, however.
// JSX Expressions must have one Parent element, without it, we would get an error.

// IMPORTANT NOTE: When using HTML class attribute, we need to use the className in JSX instead of simply class in HTML. - example shown in the div tag above.
// similarly, instead of using "for" for labels, we'd use htmlFor
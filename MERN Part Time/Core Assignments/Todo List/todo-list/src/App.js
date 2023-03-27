import React, { useState} from 'react';
import './App.css';
import TodoList from './components/js/TodoList';

function App() {
  const [todoList, setTodoList] = useState([]);
  return (
    <div className="App">
      <TodoList todoList = {todoList} setTodoList = {setTodoList}/>
    </div>
  );
}

export default App;

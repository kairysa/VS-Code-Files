import React, { useState } from 'react';
import '../css/style.css';

const TodoList = (props) => {
    const {todoList, setTodoList} = props;
    const [listItem, setListItem] = useState("");
    const [checked, setChecked] = useState(0);

    const handleSubmit = (e) =>{
        e.preventDefault();
        setTodoList([...todoList, listItem]);
        console.log(listItem);
    }

    const handleDelete = (index) => {
        const newList = todoList.filter((item, i) => {
            return i !== index;
        })
        setTodoList(newList);
    }

    return (
        <div className="Todo-list text-white">
            <h1>Todo List!</h1>
            <form onSubmit={handleSubmit} className="form form-group">
                <label htmlFor="listItem">Add To list:</label>
                <input type="text" name="listItem" onChange={(e) => setListItem(e.target.value)} value={listItem}/>
                <input type="submit" className="btn btn-secondary" value="Add"/>
            </form>
            <div className="text-white list">
                <h3>My List:</h3>
                <ul>
                    {
                    todoList.map((item, index) => (
                    <div key={index} className="d-flex justify-content-evenly m-3">
                        <li>{item}</li>
                        <input type="checkbox"/>
                        <button className="btn btn-danger" onClick={(e) => {handleDelete(index)}}>Delete</button>
                    </div>
                    ))
                    } 
                </ul>
            </div>
        </div>
    )
}

export default TodoList;
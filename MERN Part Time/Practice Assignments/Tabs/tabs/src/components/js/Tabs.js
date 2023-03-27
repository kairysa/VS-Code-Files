import React, { useState } from 'react';

const Tabs = (props) => {

    const [toggleTab, setToggleTab] = useState(0);
    const tabContent = [
        { label: "Tab 1", content: "These are all different tabs" },
        { label: "Tab 2", content: "Adding different text to test them" },
        { label: "Tab 3", content: "I dont know what to put here." },
    ]

    const handleClick = (tabNum) => {
        setToggleTab(tabNum);
        console.log(tabNum);
    }

    return (
        <div className="Tabs text-white">
            <ul className="ul">
                <li className={toggleTab === 1 ? "active-tab btn" : "li btn"} onClick={ () => handleClick(1)}>Tab 1</li>
                <li className={toggleTab === 2 ? "active-tab btn" : "li btn"} onClick={ () => handleClick(2)}>Tab 2</li>
                <li className={toggleTab === 3 ? "active-tab btn" : "li btn"} onClick={ () => handleClick(3)}>Tab 3</li>
            </ul>
            <div className="content">
                {toggleTab === 1 ? <p>{tabContent[0].content}</p> :
                toggleTab === 2 ? <p> {tabContent[1].content}</p> : 
                toggleTab === 3 ? <p> {tabContent[2].content}</p> : ""} 
            </div>
        </div>
    )
}

export default Tabs
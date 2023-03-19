// consider this code snippet - it will create a new array out of the original array and multiplaying the values by 2.

const nums = [1, 2, 3, 4, 5];

const newNums = [];

for(let i = 0; i < nums.length; i++) {
    newNums.push( nums[i] * 2 );
}

console.log( newNums ); // logs [2, 4, 6, 8, 10]

// we can accomplish the same functionality as above using the map method

const nums2 = [1, 2, 3, 4, 5];

const newNums2 = nums.map( (num) => {
    return num * 2;
} );

console.log( newNums2 ); // logs [2, 4, 6, 8, 10]

// applying this same logic in react:
import React from 'react';
    
const Groceries = (props) => {
    // this could just as easily come from props
    const groceryList = ["pearl onions", "thyme", "cremini mushrooms", "butter"];
    return (
        <ul>
        {
            groceryList.map( (item, index) => 
                <li key={ index }>{ item }</li>
            )
        }
        </ul>
    ); 
}
    
export default Groceries;





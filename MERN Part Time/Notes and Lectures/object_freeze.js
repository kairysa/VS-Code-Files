/* As we've seen before, when we declare a variable using const, we are no longer able to set it equal to a different variable, 
but if the variable is an array or object we're still able to modify that object by pushing or popping values into or from it,
or changing values that are stored in it. */

const arr = [1,2,3,4];
arr.push(300); // even though arr is declared with `const` we can still push new values into it 

// If we want to prevent those sort of changes, we can use Object.freeze()

const arr2 = Object.freeze([1,2,3,4]);
arr.push(300); // we're no longer allowed to change this variable

// take this example of an immutable list of groceries

const groceryList = Object.freeze([
    { "item": "carrots",           "haveIngredient": false },
    { "item": "onions",            "haveIngredient": true  },
    { "item": "celery",            "haveIngredient": false },
    { "item": "cremini mushrooms", "haveIngredient": false },
    { "item": "butter",            "haveIngredient": true  }
]);

// if we decide that we need to add "thyme" to the list, we can use spread to mamke a copy of it and add thyme to it

const needThyme = [ ...groceryList, { "item": "thyme", "haveIngredient": false } ];

/* the ...groceriList at the beginning is making a copy of the objects already in the groceryList array, then followed by a comma "," as if we are simply
declaring an array with a new thyme object */

//we can also use .concat() for this one. It is a method that takes two arrays, glues them together and gives us back the new array

const needThyme2 = groceryList.concat( [ { "item": "thyme", "haveIngredient": false } ] );

// if we find that we already have thyme and we want to set the have ingredient to true, we can write it like this.

const gotTheThyme = [ ...needThyme.slice(0, 5), { ...needThyme[5], "haveIngredient": true } ];

/* SLICE is a function that can take two parameters and return an array of the values that have indexes between those two parameters.

The first number (index 0 in this example) will be included in our returned array. The second number (index 5 in this example) will NOT be included
in the returned array

We can follow up that returned array with a comma and a new object - inside the new object we cna use the spread op to copy over the attributes
and overwrite its haveIngredient to be true */

// SORTING OBJECTS

const items = Object.freeze(["carrots", "onions", "celery", "mushrooms", "butter", "thyme"]);
items.sort(); // this will throw an error 

// we can however get around this with some clever use of the spread op.

const sortedItems = [...items].sort();

const numbers = [10, 5, 3, 12, 22, 8];
numbers.sort();
// this will return [10, 12, 22, 3, 5, 8 ]

// SORTING OBJECTS 

const sortedGroceries = [...groceryList].sort( (a, b) => (a.item > b.item) ? 1 : -1 );
// notice howe this time we have to write a callback function inside of sort letting it know what attribute to use when sorting - in this case using dot notation.

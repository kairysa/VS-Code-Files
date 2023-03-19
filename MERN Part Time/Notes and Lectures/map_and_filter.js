/* we can avoid writing loops in functional programming in quite a few situations */

// .map() - one of the functions that will be used most frequently. It will make a copy of an array and apply a twist to it.

const groceries = ["pearl onions", "cremini mushrooms", "thyme"];
const groceryList = groceries.map( item => `<li>${item}</li>` );

// this will take a list of items and return an array of strings resembling html "list items"

// we can also use map with an array of numbers

const values = [1, 2, 3, 4, 5];
const cubes = values.map( val => val**3 );

// this will create a list of cubed numbers

//.filter()

const values2 = [1, 2, 3, 4, 5];
const evens = values.filter( val => val % 2 === 0 );

// sometimes we want to get an array with only some of the values

//if the function returns true, the filter method will add it to the new array, if false, it wont add it.

// the example above will create a list of only even values.

// if we want a grocery list with groceries that have the letter o -
const groceries2 = ["pearl onions", "cremini mushrooms", "thyme"];
const oFoods = groceries.filter( item => item.includes("o") );


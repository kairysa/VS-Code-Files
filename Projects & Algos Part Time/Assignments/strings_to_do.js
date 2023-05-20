function removeBlanks(string) {
  let newString = "";
  for (let i=0; i<string.length; i++) {
    if(string[i] != " ") {
      newString += string[i];
    } 
  }
  return newString;
}

let testString = "t e s t i n g";

console.log(removeBlanks(testString));

function getDigits(string){
  let newString = "";
  for (let i=0; i<string.length; i++) {
    if(Number(string[i])) {
      newString += string[i];
    }
  }
  return newString;
}

testString = "asjdadh98b12bg1239213803123n";

console.log(getDigits(testString));

function acronym(string) {
  const splitString = string.split(' ');
  let newString = "";
  for(let i=0; i<splitString.length; i++) {
    newString += splitString[i][0].toUpperCase();
  }
  return newString;
}

testString = "Welcome to coding dojo";

console.log(acronym(testString));

function countNonSpaces(string) {
  let count = 0;
  for(let i=0; i<string.length; i++) {
    if(string[i] != " ") {
      count += 1;
    }
  }
  return count;
}

testString = "This is a test to see if I did this correctly";

console.log(countNonSpaces(testString));

function removeShorterStrings(string, num) {
  const splitString = string.split(' ');
  let output = [];
  for(let i=0; i<splitString.length; i++){
    if(splitString[i].length >= num) {
      output.push(splitString[i]);
    }
  }
  return output;
}

console.log(removeShorterStrings(testString, 3));

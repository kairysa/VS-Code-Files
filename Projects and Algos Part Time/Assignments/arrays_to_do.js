function pushFront(arr, num) {
  for(let i=arr.length; i>0; i--) {
    arr[i] = arr[i-1];
  }
  arr[0] = num;
  return arr;
}

let testArray = [0,1,2,3,4,5];
console.log(pushFront(testArray, 9));

function popFront(arr) {
  let num = arr[0];
  for(let i=1; i<arr.length; i++){
    arr[i-1] = arr[i];
  };
  arr.pop();
  console.log(arr);
  return num;
}

let testArrayTwo = [99,22,32,45,64]
console.log(popFront(testArrayTwo));

function removeAt(arr, index) {
  let num = arr[index];
  for(let i=index; i<arr.length; i++) {
    arr[i] = arr[i+1];
  }
  arr.pop();
  console.log(arr);
  return num;
}

let testArrayThree = [1,2,3,4,5,6,7];
console.log(removeAt(testArrayThree, 0));

function insertAt(arr, index, num){
  for(let i=arr.length; i>index; i--){
    arr[i] = arr[i-1];
  }
  arr[index] = num;
  return arr;
}

testArrayFour = [0,1,2,3,4,5,6];

console.log(insertAt(testArrayFour, 4, 200));
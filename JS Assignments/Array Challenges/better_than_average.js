var arr = [6, 8, 3, 10, -2, 9, 5];
var sum = 0;
var avg = 0;
var count = 0;

function betterThanAverage(arr){
    for(i=0; i<arr.length; i++){
        sum += arr[i];
    }
    avg = sum/7;
    for(i=0; i<arr.length; i++){
        if (arr[i] > avg){
            count += 1;
        }
    }
    return count;
}

betterThanAverage(arr);

console.log(count);
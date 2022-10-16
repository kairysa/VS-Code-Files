var numList = [6, 8, 3, 10, -2, 9, 5];
var sum = 0;
var avg = 0;
var count = 0;

function betterThanAverage(){
    for(i=0; i<numList.length; i++){
        sum += numList[i];
    }
    avg = sum/7;

}

betterThanAverage();
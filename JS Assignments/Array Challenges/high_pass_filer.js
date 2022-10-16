var numberList = [-9, -14, -25, -65, 0, 23, 54, 75, 38];

function highPass(){
    for(i=0; i<numberList.length; i++){
        if (numberList[i] >=-100) {
            console.log(numberList[i]);
        }
    }
}

highPass();
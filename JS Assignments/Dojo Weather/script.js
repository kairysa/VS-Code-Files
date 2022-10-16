var temp1 = document.querySelector("#temp1box1");
var temp2 = document.querySelector("#temp2box1");
var temp3 = document.querySelector("#temp1box2");
var temp4 = document.querySelector("#temp2box2");
var temp5 = document.querySelector("#temp1box3");
var temp6 = document.querySelector("#temp2box3");
var temp7 = document.querySelector("#temp1box4");
var temp8 = document.querySelector("#temp2box4");

// Choose Temp //

function chooseTemp(element){
    if (element.value == "°C") {
        temp1.innerText = "24°";
        temp2.innerText = "18°";
        temp3.innerText = "27°";
        temp4.innerText = "19°";
        temp5.innerText = "21°";
        temp6.innerText = "16°";
        temp7.innerText = "26°";
        temp8.innerText = "21°";
    }
    else if (element.value == "°F") {
        temp1.innerText = "75°";
        temp2.innerText = "65°";
        temp3.innerText = "80°";
        temp4.innerText = "66°";
        temp5.innerText = "69°";
        temp6.innerText = "61°";
        temp7.innerText = "78°";
        temp8.innerText = "70°";
    }
}






// Weather Report //

function weatherAlert(){
    alert("Loading weather report....");
}

// Cookie Button //

function accept(){
    document.querySelector("#cookie-box").remove();
}
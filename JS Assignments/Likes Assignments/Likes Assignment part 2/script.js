var x = 9;
var y = 12;
var z = 9;
var like1 = document.querySelector("#like1");
var like2 = document.querySelector("#like2");
var like3 = document.querySelector("#like3");

function add1(){
    x++;
    like1.innerText = x + " like(s)";
}

function add2(){
    y++;
    like2.innerText = y + " like(s)";
}

function add3(){
    z++;
    like3.innerText = z + " like(s)";
}
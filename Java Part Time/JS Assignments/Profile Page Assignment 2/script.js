var phil = document.querySelector("#philk");
var todd = document.querySelector("#todde");
var requestnumber = 2;
var friendnumber = 418;
var friendCount = document.querySelector("#number-count")
var requestCount = document.querySelector("#request-number");
var profileName = document.querySelector("#name");

function accept1(){
    friendnumber++;
    requestnumber--;
    todd.remove();
    friendCount.innerText = friendnumber;
    requestCount.innerText = requestnumber;
}
function decline1(){
    friendnumber--;
    requestnumber--;
    todd.remove();
    requestCount.innerText = requestnumber;
}
function accept2(){
    friendnumber++;
    requestnumber--;
    phil.remove();
    friendCount.innerText = friendnumber;
    requestCount.innerText = requestnumber;
}
function decline2(){
    friendnumber--;
    requestnumber--;
    phil.remove();
    requestCount.innerText = requestnumber;
}
function editprofile(){
    profileName.innerHTML = '<input type="text" value="">';
}
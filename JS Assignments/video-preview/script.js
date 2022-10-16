console.log("page loaded...");

var vid = document.getElementById("saul-vid");
vid.muted = true;

function vidm() {
    if (vid.muted == true) {
        vid.muted = false;
    }
    else if (vid.muted == false) {
        vid.muted = true;
    }
}
function onmouseover(element){
    element.play();
}
function onmouseout(element){
    element.pause();
}
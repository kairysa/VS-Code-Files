var likeElement = document.querySelector("#like-count")
var count = 3;

function add1() {
    count++;
    likeElement.innerText = count + " like(s)";
    console.log(count)
}
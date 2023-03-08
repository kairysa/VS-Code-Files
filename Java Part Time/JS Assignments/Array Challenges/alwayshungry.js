var foodlist = ["pie","pizza","chips","sushi","pie","candy"];

function alwaysHungry(){
    for(i=0; i<foodlist.length; i++){
        if(foodlist[i] == "pie") {
            console.log("yummy");
        }
        else {
        console.log(foodlist[i]);
        }
    }
}
alwaysHungry();


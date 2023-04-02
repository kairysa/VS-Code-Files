function tossCoin() {
    return Math.random() > 0.5 ? "heads" : "tails";
    }

function fiveHeads() {
    return new Promise((resolve, reject) => {
        let headsCount = 0;
        let attempts = 0;
        while(headsCount < 5) {
            attempts++;
            let result = tossCoin();
            console.log(`${result} was flipped`);
            if(result === "heads"){
                headsCount++;
            } else {
                headsCount = 0;
            }
        }
        if (attempts <= 100) {
            resolve(`Coin was flipped ${attempts} times before getting 5 heads`);
        } else {
            reject("Could not get 5 heads in 100 attempts");
        }
    })}

fiveHeads()
    .then( res => console.log(res) )
    .catch( err => console.log(err) );


/* function fiveHeadsSync() {
    let headsCount = 0;
    let attempts = 0;
    while(headsCount < 5) {
        attempts++;
        let result = tossCoin();
        console.log(`${result} was flipped`);
        if(result === "heads") {
            headsCount++;
        } else {
            headsCount = 0;
        }
    }
        return `It took ${attempts} tries to flip five "heads"`;
        }
console.log( fiveHeadsSync() );
console.log( "This is run after the fiveHeadsSync function completes" ); */
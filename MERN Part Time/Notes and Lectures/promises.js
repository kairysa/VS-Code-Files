/* Promises have three states:
Pending: the outcome is not yet determined
Resolved: the outcome is completed successfully
Rejected: the outcome is completed with errors
*/


// An example of a promise would look like:

const noMondays = new Promise( (resolve, reject) => {
    if(new Date().getDay() !== 1) {
        resolve("Good, it's not Monday!");
    } else {
        reject("Someone has a case of the Mondays!");
    }
});
noMondays
    .then( res => console.log(res) )
    .catch( err => console.log(err) );

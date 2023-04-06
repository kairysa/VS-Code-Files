const mongoose = require('mongoose');


//                                          only need to change db name here - it will automatically create a database if it doesnt exist.
mongoose.connect('mongodb://127.0.0.1:27017/jokes', {
    useNewUrlParser: true,
    useUnifiedTopology: true
})
    .then(() => console.log('Established a connection to the database'))
    .catch(err => console.log('Something went wrong when connecting to the database ', err));
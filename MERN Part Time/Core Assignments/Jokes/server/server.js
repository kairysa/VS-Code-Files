const express = require("express");
const app = express();
    
require("./config/mongoose.config"); // calling the mongoose.config file and running the connect function
    
app.use(express.json(), express.urlencoded({ extended: true }));
    
const AllJokeRoutes = require("./routes/joke.routes");
AllJokeRoutes(app);
    
app.listen(8000, () => console.log("The server is all fired up on port 8000"));

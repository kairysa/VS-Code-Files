const express = require("express");
const app = express();
const cors = require('cors');
app.use(cors());
    
require("./config/mongoose.config"); // calling the mongoose.config file and running the connect function
    
app.use(express.json(), express.urlencoded({ extended: true }));
    
const AllShowRoutes = require("./routes/tvshow.routes");
AllShowRoutes(app);
    
app.listen(8000, () => console.log("The server is all fired up on port 8000"));

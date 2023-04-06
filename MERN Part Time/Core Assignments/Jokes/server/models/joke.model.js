const mongoose = require('mongoose');

const JokeSchema = new mongoose.Schema({
    setup: {
      type: String
    },
    punchline: {
      type: String
    },
    createdAt: {
      type: Date,
      default: Date.now
    },
    updatedAt: {
      type: Date,
      default: Date.now
    }
});

const Joke = mongoose.model('Joke', JokeSchema);

module.exports = Joke;
const mongoose = require('mongoose');

const TvShow = new mongoose.Schema({
    title: {
      type: String
    },
    releaseYear: {
      type: Number
    },
    network: {
      type: String
    },
    creator: {
      type: String
    },
    genre: {
      type: String
    }
});

const Show = mongoose.model('Show', TvShow);

module.exports = Show;

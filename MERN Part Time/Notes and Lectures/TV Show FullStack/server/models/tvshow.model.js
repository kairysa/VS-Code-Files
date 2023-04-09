const mongoose = require('mongoose');

const TvShow = new mongoose.Schema({
    title: {
      type: String,
      required:[true, 'Title is required'],
      minLength:[3, 'Title must be 3 or more characters'],
      maxLength:[50,'Title is too long']
    },
    releaseYear: {
      type: Number,
      min: [1920, "No years before 1920 allowed"]
    },
    network: {
      type: String,
      required:[true, 'Network is required'],
      minLength:[3, 'Network must be 3 or more characters'],
      maxLength:[50,'Network is too long']
    },
    creator: {
      type: String,
      required:[true, 'Creator is required'],
      minLength:[3, 'Creator must be 3 or more characters'],
      maxLength:[50,'Creator is too long']
    },
    genre: {
      type: String,
      required:[true, 'Creator is required'],
      minLength:[3, 'Creator must be 3 or more characters'],
      maxLength:[50,'Title is too long']
    }

    // ! ADD TIMESTAMPS //
}, {timestamps:true});

const Show = mongoose.model('Show', TvShow);

module.exports = Show;

const { request } = require('http');
const Show = require('../models/tvshow.model');

module.exports.findAllShows = (req, res) => {
    Show.find()
        .then((allShows) => {
            res.json({ shows: allShows })
        })
        .catch((err) => {
            res.json({ message: 'Something went wrong', error: err })
        });
}

module.exports.createShow = (req, res) => {
  Show.create(req.body)
    .then((newShow) => {
      res.json({show: newShow});
    })
    .catch((err) => res.status(400).json(err));
}

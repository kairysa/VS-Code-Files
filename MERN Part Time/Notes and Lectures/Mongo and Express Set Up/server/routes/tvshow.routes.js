const TvShowController = require('../controllers/tvshow.controller');

module.exports = app => {
  app.get('/api/allshows', TvShowController.findAllShows);
  app.post('/api/newshow', TvShowController.createShow);
}
const JokeController = require('../controllers/joke.controller');

module.exports = app => {
  app.get('/api/jokes', JokeController.findAllJokes);
  app.post('/api/jokes', JokeController.createJoke);
  app.get('/api/jokes/:id', JokeController.findOneJoke);
  app.put('/api/jokes/:id', JokeController.updateJoke);
  app.delete('/api/jokes/:id', JokeController.deleteJoke);
}
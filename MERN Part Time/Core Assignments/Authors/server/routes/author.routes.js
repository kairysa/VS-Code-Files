const AuthorController = require('../controllers/author.controller')

module.exports = (app) => {
  app.get('/api', AuthorController.findAllAuthors);
  app.get('/api/:id', AuthorController.findAuthor);
  app.post('/api/author', AuthorController.createAuthor);
  app.put('/api/:id', AuthorController.updateAuthor);
  app.delete('/api/:id', AuthorController.deleteAuthor);
}
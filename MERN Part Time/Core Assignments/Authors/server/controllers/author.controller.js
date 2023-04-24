const Author = require('../models/author.model');

module.exports.findAllAuthors = (req, res) => {
  Author.find()
    .then((allAuthors) => {
      console.log(allAuthors);
      res.json({authors: allAuthors});
    })
    .catch((err) => res.status(400).json(err));
}

module.exports.findAuthor = (req, res) => {
  Author.findOne({_id: req.params.id})
    .then(author => {
      console.log(author);
      res.json(author)
    })
    .catch((err) => res.status(400).json(err));
}

module.exports.createAuthor = (req, res) => {
  Author.create(req.body)
    .then(Author => res.json(Author))
    .catch((err) => res.status(400).json(err));
}

module.exports.updateAuthor = (req, res) => {
  Author.findOneAndUpdate({_id: req.params.id}, req.body, {new:true})
    .then(updatedAuthor => {
      console.log(updatedAuthor);
      res.json(updatedAuthor)})
      .catch((err) => res.status(400).json(err));
}

module.exports.deleteAuthor = (req, res) => {
  Author.deleteOne({_id: req.params.id})
    .then(deletedAuthor => res.json(deletedAuthor))
    .catch((err) => res.status(400).json(err));
}
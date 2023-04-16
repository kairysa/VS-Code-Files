const Product = require('../models/product.model');
module.exports.index = (req, res) => {
  res.json({
    message: "Test"
  });
}

module.exports.findAllProducts = (req, res) => {
  Product.find()
    .then((allProducts) => {
      console.log(allProducts);
      res.json({products : allProducts});
    })
    .catch((err) => {
      res.json({ message: 'Something went wrong', error: err })
  });
}

module.exports.findProduct = (req, res) => {
  Product.findOne({_id:req.params.id})
    .then(product => {
      console.log(product);
      res.json(product)})
    .catch((err) => {
      res.json({ message: 'Something went wrong', error: err })
  });
}

module.exports.createProduct = (req, res) => {
  Product.create(req.body)
    .then(product => res.json(product))
    .catch((err) => {
      res.json({ message: 'Something went wrong', error: err })
    });
}

module.exports.updateProduct = (req, res) => {
  Product.findOneAndUpdate({_id: req.params.id}, req.body, {new:true})
    .then(updatedProduct => {
      console.log(updatedProduct);
      res.json(updatedProduct)})
    .catch((err) => {
      res.json({ message: 'Something went wrong', error: err })
    });
}

module.exports.deleteProduct = (req, res) => {
  Product.deleteOne({_id: req.params.id})
    .then(deletedProduct => res.json(deletedProduct))
    .catch((err) => {
      res.json({ message: 'Something went wrong', error: err })
    });
}
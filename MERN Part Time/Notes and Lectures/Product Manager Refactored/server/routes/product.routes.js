const ProductController = require('../controllers/product.controller');
module.exports = (app) => {
  app.get('/api', ProductController.findAllProducts);
  app.get('/api/:id', ProductController.findProduct);
  app.post('/api/product', ProductController.createProduct);
  app.put('/api/:id', ProductController.updateProduct);
  app.delete('/api/:id', ProductController.deleteProduct);
}
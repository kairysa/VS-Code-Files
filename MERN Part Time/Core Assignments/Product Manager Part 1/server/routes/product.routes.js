const ProductController = require('../controllers/product.controller');
module.exports = (app) => {
  app.get('/api', ProductController.findAllProducts);
  app.post('/api/product', ProductController.createProduct);
}
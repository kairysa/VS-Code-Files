const mongoose = require('mongoose');

const ProductSchema = new mongoose.Schema({

  productName: {
    type: String,
    required: [true, 'Product Name is required'],
    minLength: [2, 'Product name must be at least 2 characters']
  },
  price: {
    type: Number,
    required: [true, 'Price is required'],
    min: [0, "Price cannot be negative"]
  },
  description: {
    type: String,
    required: [true, 'Description is required'],
    minLength: [10, 'Description must be at least 10 characters'],
    maxLength: [400, 'Description cannot exceed 400 characters']
  }
}, {timestamps: true});

module.exports = mongoose.model('Product', ProductSchema);
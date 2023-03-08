package com.noahgardner.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noahgardner.productsandcategories.models.Product;
import com.noahgardner.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository repo;
	
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}
	
	public Product updateOrCreate(Product b) {
		return repo.save(b);
	}
	
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
	
	public Product findOne(Long id) {
		Optional<Product> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public List<Product> findAll() {
		return repo.findAll();
	}
}

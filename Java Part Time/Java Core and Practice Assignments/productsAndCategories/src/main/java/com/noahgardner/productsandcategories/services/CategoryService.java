package com.noahgardner.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noahgardner.productsandcategories.models.Category;
import com.noahgardner.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository repo;
	
	public CategoryService(CategoryRepository repo) {
		this.repo = repo;
	}
	
	public Category updateOrCreate(Category b) {
		return repo.save(b);
	}
	
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
	
	public Category findOne(Long id) {
		Optional<Category> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public List<Category> findAll() {
		return repo.findAll();
	}
}

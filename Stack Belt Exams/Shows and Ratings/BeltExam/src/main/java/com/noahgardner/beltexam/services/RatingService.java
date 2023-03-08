package com.noahgardner.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noahgardner.beltexam.models.Rating;
import com.noahgardner.beltexam.repositories.RatingRepository;

@Service
public class RatingService {
	
	public final RatingRepository repo;
	
	public RatingService(RatingRepository repo) {
		this.repo = repo;
	}
	
	public Rating updateOrCreate(Rating b) {
		return repo.save(b);
	}
	
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
	
	public Rating findOne(Long id) {
		Optional<Rating> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public List<Rating> findAll() {
		return repo.findAll();
	}
}

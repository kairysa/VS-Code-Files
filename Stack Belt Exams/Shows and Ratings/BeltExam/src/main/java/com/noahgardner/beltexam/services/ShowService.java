package com.noahgardner.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noahgardner.beltexam.models.Show;
import com.noahgardner.beltexam.repositories.ShowRepository;

@Service
public class ShowService {
	
	public final ShowRepository repo;
	
	public ShowService(ShowRepository repo) {
		this.repo = repo;
	}
	
	public Show updateOrCreate(Show b) {
		return repo.save(b);
	}
	
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
	
	public Show findOne(Long id) {
		Optional<Show> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public List<Show> findAll() {
		return repo.findAll();
	}
}

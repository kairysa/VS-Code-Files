package com.noahgardner.bandtogether.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noahgardner.bandtogether.models.Venue;
import com.noahgardner.bandtogether.repositories.VenueRepository;

@Service
public class VenueService {
	@Autowired
	private VenueRepository repo;
	
	public Venue createOrUpdate(Venue b) {
		return repo.save(b);
	}
	
	public Venue findOne(Long id) {
		Optional<Venue> i = repo.findById(id);
		if (i.isPresent()) {
			return i.get();
		}
		else {
			return null;
		}
	}
	
	public List<Venue> findOne() {
		return repo.findAll();
	}
	
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
}

package com.noahgardner.bandtogether.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noahgardner.bandtogether.models.Band;
import com.noahgardner.bandtogether.repositories.BandRepository;

@Service
public class BandService {
	@Autowired
	private BandRepository repo;
	
	public Band createOrUpdate(Band b) {
		return repo.save(b);
	}
	
	public Band findOne(Long id) {
		Optional<Band> i = repo.findById(id);
		if (i.isPresent()) {
			return i.get();
		}
		else {
			return null;
		}
	}
	
	public List<Band> findOne() {
		return repo.findAll();
	}
	
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
}

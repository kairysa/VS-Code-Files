package com.noahgardner.bandtogether.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noahgardner.bandtogether.models.Event;
import com.noahgardner.bandtogether.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository repo;
	
	public Event createOrUpdate(Event b) {
		return repo.save(b);
	}
	
	public Event findOne(Long id) {
		Optional<Event> i = repo.findById(id);
		if (i.isPresent()) {
			return i.get();
		}
		else {
			return null;
		}
	}
	
	public List<Event> findOne() {
		return repo.findAll();
	}
	
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
}

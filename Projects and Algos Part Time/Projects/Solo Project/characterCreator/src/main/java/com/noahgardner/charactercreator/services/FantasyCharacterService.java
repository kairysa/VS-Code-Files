package com.noahgardner.charactercreator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.noahgardner.charactercreator.models.FantasyCharacter;
import com.noahgardner.charactercreator.repositories.FantasyCharacterRepository;

@Service
public class FantasyCharacterService {
	
	private final FantasyCharacterRepository repo;
	
	public FantasyCharacterService(FantasyCharacterRepository repo) {
		this.repo = repo;
	}
	
	public FantasyCharacter createCharacter(FantasyCharacter b, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<FantasyCharacter> characterName = repo.findByName(b.getName());
		
		if(characterName.isPresent()) {
			result.rejectValue("name", "name", "Name already exists.");
			return null;
		}
		else {
			return repo.save(b);
		}
	}
	
	public FantasyCharacter updateCharacter(FantasyCharacter b) {
		return repo.save(b);
	}
	
	public FantasyCharacter findOne(Long id) {
		Optional<FantasyCharacter> i = repo.findById(id);
		if (i.isPresent()) {
			return i.get();
		}
		else {
			return null;
		}
	}
	
	public List<FantasyCharacter> findAll() {
		return repo.findAll();
	}
	
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
}

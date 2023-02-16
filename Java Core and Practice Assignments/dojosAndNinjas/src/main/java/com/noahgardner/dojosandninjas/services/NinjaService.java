package com.noahgardner.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noahgardner.dojosandninjas.models.Ninja;
import com.noahgardner.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	public Ninja createNinja(Ninja b) {
		return ninjaRepository.save(b);
	}
	
	public Ninja updateNinja(Ninja b) {
		return ninjaRepository.save(b);
	}
	
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
}

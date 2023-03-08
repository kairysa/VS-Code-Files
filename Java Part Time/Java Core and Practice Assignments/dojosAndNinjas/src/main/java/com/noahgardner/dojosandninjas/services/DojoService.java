package com.noahgardner.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noahgardner.dojosandninjas.models.Dojo;
import com.noahgardner.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	
	public Dojo createDojo(Dojo b) {
		return dojoRepository.save(b);
	}
	
	public Dojo updateDojo(Dojo b) {
		return dojoRepository.save(b);
	}
	
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
}

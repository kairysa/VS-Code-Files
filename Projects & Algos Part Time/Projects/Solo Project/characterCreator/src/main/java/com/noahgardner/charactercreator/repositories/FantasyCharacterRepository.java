package com.noahgardner.charactercreator.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.noahgardner.charactercreator.models.FantasyCharacter;

public interface FantasyCharacterRepository extends CrudRepository<FantasyCharacter, Long>{
	List<FantasyCharacter> findAll();
	Optional<FantasyCharacter> findByName(String name);
}

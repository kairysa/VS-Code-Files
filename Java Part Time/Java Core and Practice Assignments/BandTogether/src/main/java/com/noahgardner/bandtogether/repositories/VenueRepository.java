package com.noahgardner.bandtogether.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noahgardner.bandtogether.models.Venue;

public interface VenueRepository extends CrudRepository<Venue, Long>{
	List<Venue> findAll();
}

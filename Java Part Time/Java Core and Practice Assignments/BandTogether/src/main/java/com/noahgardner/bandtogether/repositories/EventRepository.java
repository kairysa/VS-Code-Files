package com.noahgardner.bandtogether.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noahgardner.bandtogether.models.Event;

public interface EventRepository extends CrudRepository<Event, Long>{
	List<Event> findAll();
}

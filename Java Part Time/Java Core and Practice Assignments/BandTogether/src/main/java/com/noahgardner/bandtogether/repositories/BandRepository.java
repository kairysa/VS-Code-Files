package com.noahgardner.bandtogether.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noahgardner.bandtogether.models.Band;

public interface BandRepository extends CrudRepository<Band, Long>{
	List<Band> findAll();
}

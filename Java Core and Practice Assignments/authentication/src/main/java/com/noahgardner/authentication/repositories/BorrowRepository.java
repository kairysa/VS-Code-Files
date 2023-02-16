package com.noahgardner.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.noahgardner.authentication.models.Borrow;

public interface BorrowRepository extends CrudRepository<Borrow, Long>{
	List<Borrow> findAll();

}

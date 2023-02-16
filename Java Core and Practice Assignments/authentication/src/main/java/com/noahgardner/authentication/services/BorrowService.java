package com.noahgardner.authentication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.noahgardner.authentication.models.Borrow;
import com.noahgardner.authentication.repositories.BorrowRepository;

@Service
public class BorrowService {
	
	private final BorrowRepository borrowRepository;
	
	public BorrowService(BorrowRepository borrowRepository) {
		this.borrowRepository = borrowRepository;
	}
	
	public List<Borrow> allBorrows() {
		return borrowRepository.findAll();
	}
	
	public Borrow createBorrow(Borrow b) {
		return borrowRepository.save(b);
	}
	
	public Borrow updateBorrow(Borrow b) {
		return borrowRepository.save(b);
	}
	
	public void deleteBorrow(Long id) {
		borrowRepository.deleteById(id);
	}
	
	public Borrow findBorrow (Long id) {
		Optional<Borrow> optionalBorrow = borrowRepository.findById(id);
		if(optionalBorrow.isPresent()) {
			return optionalBorrow.get();
		}
		else {
			return null;
		}
	}

}

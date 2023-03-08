package com.noahgardner.bandtogether.services;
import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.noahgardner.bandtogether.models.User;
import com.noahgardner.bandtogether.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public User register(User newUser, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<User> user = repo.findByEmail(newUser.getEmail());
		
		if(user.isPresent()) {
			result.rejectValue("email", "email", "Email already in use.");
			return null;
		}
		
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "password", "Passwords must match");
			return null;
		}
		
		else {
			String password = newUser.getPassword();
			String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
			newUser.setPassword(hashed);
			return repo.save(newUser);
		}
	}
	
	public User createOrUpdate(User b) {
		return repo.save(b);
	}
	
	public User findOne(Long id) {
		Optional<User> i = repo.findById(id);
		if (i.isPresent()) {
			return i.get();
		}
		else {
			return null;
		}
	}
	
	public List<User> findOne() {
		return repo.findAll();
	}
	
	public void deleteOne(Long id) {
		repo.deleteById(id);
	}
}

package com.noahgardner.charactercreator.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.noahgardner.charactercreator.models.LoginUser;
import com.noahgardner.charactercreator.models.User;
import com.noahgardner.charactercreator.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public UserService(UserRepository repo) {
		this.repo = repo;
	}
	
	public User register(User newUser, BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<User> userEmail = repo.findByEmail(newUser.getEmail());
		Optional<User> userName = repo.findByUserName(newUser.getUserName());
		
		if(userEmail.isPresent()) {
			result.rejectValue("email","email", "Email already in use.");
			return null;
		}		
		if(userName.isPresent()) {
			result.rejectValue("userName","userName", "Username already exists");
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
	
	
	public User login(LoginUser loginUser, BindingResult result) {
		Optional<User> optionalUser = repo.findByEmail(loginUser.getEmail());
		if (optionalUser.isPresent()) {
			if(!BCrypt.checkpw(loginUser.getPassword(), optionalUser.get().getPassword())) {
				result.rejectValue("password", "Matches", "Invalid Password!");
				return null;
			}
			else {
				return findUser(optionalUser.get().getId());
			}
		}
		else if(result.hasErrors()) {
			return null;
		}
		else {
			result.rejectValue("email", "email", "Invalid Email/Password!");
			return null;
		}
	}
	
	public List<User> allUsers(){
		return repo.findAll();
	}
	
	public User createUser(User b) {
		return repo.save(b);
	}
	
	public User updateUser(User b) {
		return repo.save(b);
	}
	
	public void deleteUser(Long id) {
		repo.deleteById(id);
	}
	
	public User findUser(Long id) {
		Optional<User> optionalUser = repo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
}

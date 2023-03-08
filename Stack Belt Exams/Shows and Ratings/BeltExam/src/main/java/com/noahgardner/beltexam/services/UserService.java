package com.noahgardner.beltexam.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.noahgardner.beltexam.models.LoginUser;
import com.noahgardner.beltexam.models.User;
import com.noahgardner.beltexam.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User register(User newUser, BindingResult result) {
		Optional<User> optionalUser = userRepository.findByEmail(newUser.getEmail());
		if(result.hasErrors()) {
			return null;
		}		
		else if (optionalUser.isPresent()) {
			result.rejectValue("email", "email" , "User already exists!");
			return null;
		}
		else if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The Confirm password must match Password!");
			return null;
		}
		else {
			String password = newUser.getPassword();
			String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
			newUser.setPassword(hashed);
			return createUser(newUser);
		}
	}
	
	public User login(LoginUser loginUser, BindingResult result) {
		Optional<User> optionalUser = userRepository.findByEmail(loginUser.getEmail());
		if(result.hasErrors()) {
			return null;
		}
		else if (optionalUser.isPresent()) {
			if(!BCrypt.checkpw(loginUser.getPassword(), optionalUser.get().getPassword())) {
				result.rejectValue("password", "Matches", "Invalid Password!");
				return null;
			}
			else {
				System.out.println(optionalUser);
				return findUser(optionalUser.get().getId());
			}
		}
		else {
			result.rejectValue("email", "email", "Invalid Email/Password!");
			return null;
		}
	}
	
	public List<User> allUsers(){
		return userRepository.findAll();
	}
	
	public User createUser(User b) {
		return userRepository.save(b);
	}
	
	public User updateUser(User b) {
		return userRepository.save(b);
	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	public User findUser(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
}

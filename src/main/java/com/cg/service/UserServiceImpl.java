package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.cg.Exception.UserNotFoundException;
import com.cg.Exception.UserNotSavedException;
import com.cg.Exception.WrongPasswordException;
import com.cg.dto.User;
import com.cg.repo.UserRepo;

public class UserServiceImpl implements UserService {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserRepo repo;
	@Override
	public User signUp(User user) throws UserNotSavedException {
		String password = user.getUserPassword();
		String encodedPassword = passwordEncoder.encode(password);
		user.setUserPassword(encodedPassword);
		User user1 = repo.save(user);
		if(user1 == null)
			throw new UserNotSavedException("Unable to save. Something went wrong. Please try again");
		return user1;
	}

	@Override
	public User getById(String id) throws UserNotFoundException {
		User user;
		try {
			user = repo.findById(id).get();
		} catch (Exception e) {
			throw new UserNotFoundException("User not found with id "+id);
		}
		return user;
	}

	@Override
	public User update(User user) {
		return repo.save(user);
	}

	@Override
	public User login(String id, String password) throws UserNotFoundException, WrongPasswordException {
		User user;
		try {
			user = repo.findById(id).get();
		} catch (Exception e) {
			throw new UserNotFoundException("User not found with id "+id);
		}
		String encodedPassword = user.getUserPassword();
		if (passwordEncoder.matches(password, encodedPassword)) {
			return user;
		} else {
			throw new WrongPasswordException("Password does not match. Please enter valid password");
		}
	}

	@Override
	public List<User> getAll() throws UserNotFoundException {
		try {
			return repo.findAll();
		} catch (Exception e) {
			throw new UserNotFoundException("User list is empty");
		}
	}

	@Override
	public List<User> getByUserRole(String userRole) {
		return repo.getByUserRole(userRole);
	}

}

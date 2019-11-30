package com.cg.service;

import java.util.List;

import com.cg.Exception.UserNotFoundException;
import com.cg.Exception.UserNotSavedException;
import com.cg.Exception.WrongPasswordException;
import com.cg.dto.User;

public interface UserService {
	User signUp(User user) throws UserNotSavedException;
	User getById(String id) throws UserNotFoundException;
	User update(User user);
	User login(String id, String password) throws UserNotFoundException, WrongPasswordException;
	List<User> getAll() throws UserNotFoundException;
	List<User> getByUserRole(String userRole);
}

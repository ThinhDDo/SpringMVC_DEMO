package com.spring.exam.sys.service;

import java.util.List;

import com.spring.exam.sys.model.User;

public interface UserService {
	User getUserById(String id);
	List<User> getUsersByName(String name);
	List<User> getUsers();
	void addUser(User user);
	void deleteUser(String id);
	void updateUser(User user);
}

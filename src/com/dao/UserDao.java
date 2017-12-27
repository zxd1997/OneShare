package com.dao;

import java.util.List;

import com.beans.User;

public interface UserDao {
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public List<User> selectUser();
	public User getUserById(int id);
	public User getUserByName(String name);
	public boolean isExisted(String name);
}

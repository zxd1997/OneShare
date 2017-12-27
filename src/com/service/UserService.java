package com.service;
import java.util.List;

import com.beans.User;
public interface UserService {
	public boolean isExisted(String userName);
	public void save(User user);
	public List<User> getUsers();
	public void del(User user);
	public void update(User user);
	public User getUser(int id);
	public boolean login(String userName,String passWord);
	public User getUserByName(String userName);
}

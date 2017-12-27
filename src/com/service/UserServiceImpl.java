package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.beans.User;
import com.dao.UserDao;
@Service 
@Scope("prototype")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public boolean isExisted(String userName) {
		// TODO 自动生成的方法存根
		return userDao.isExisted(userName);
	}

	@Override
	public void save(User user) {
		// TODO 自动生成的方法存根
		userDao.addUser(user);
	}

	@Override
	public List<User> getUsers() {
		// TODO 自动生成的方法存根
		return userDao.selectUser();
	}

	@Override
	public void del(User user) {
		// TODO 自动生成的方法存根
		userDao.deleteUser(user);
	}

	@Override
	public void update(User user) {
		// TODO 自动生成的方法存根
		userDao.updateUser(user);
	}

	@Override
	public User getUser(int id) {
		// TODO 自动生成的方法存根
		return userDao.getUserById(id);
	}

	@Override
	public boolean login(String userName, String passWord) {
		// TODO 自动生成的方法存根
		User user=userDao.getUserByName(userName);
		if (user==null)return false;
		if (!user.getPassword().equals(passWord))return false;
		return true;
	}

	public User getUserByName(String userName) {
		// TODO 自动生成的方法存根
		return userDao.getUserByName(userName);
	}
	
}

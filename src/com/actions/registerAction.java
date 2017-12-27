package com.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beans.User;
import com.dao.UserDao;
import com.dao.UserDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserServiceImpl;
@Controller
@Scope("prototype")
public class registerAction extends ActionSupport {
	@Autowired
	private UserServiceImpl us;
	private User user=new User();
	public String execute() {
		user.setBalance(10000);
		user.setCredit(70);
		System.out.println(user.getGender());
		us.save(user);
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}

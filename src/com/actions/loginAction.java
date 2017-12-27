package com.actions;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beans.User;
import com.opensymphony.xwork2.*;
import com.service.UserServiceImpl;
@Controller
@Scope("prototype")
public class loginAction extends ActionSupport{
	HttpSession session=ServletActionContext.getRequest().getSession(); 
	private String username;
	private String password;
	@Autowired
	private UserServiceImpl us;
	public loginAction() {
	}
	public String execute() throws Exception {
		if (us.login(username, password)) {
			session.setAttribute("userName",username);
			return SUCCESS;
		}
		else return ERROR;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getnUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}

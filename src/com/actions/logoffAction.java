package com.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class logoffAction extends ActionSupport {

	HttpSession session=ServletActionContext.getRequest().getSession(); 
	public String execute() throws Exception{
		session.removeAttribute("userName");
		return SUCCESS;
	}
}

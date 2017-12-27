package com.actions;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beans.Order;
import com.beans.Product;
import com.beans.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.OrderService;
import com.service.ProductService;
import com.service.UserServiceImpl;
@Controller
@Scope("prototype")
public class userAction extends ActionSupport {
	@Autowired
	UserServiceImpl us;
	@Autowired
	ProductService ps;
	@Autowired
	OrderService os;
	HttpSession session=ServletActionContext.getRequest().getSession(); 
	private List<Product> plist;
	private List<Order> olist;
	private User user;
	public String execute() throws Exception{
		user=us.getUserByName((String)session.getAttribute("userName"));
		setPlist(ps.getProductByUser(user.getId()));
		setOlist(os.getOrderByUserId(user.getId()));
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Order> getOlist() {
		return olist;
	}
	public void setOlist(List<Order> olist) {
		this.olist = olist;
	}
	public List<Product> getPlist() {
		return plist;
	}
	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}
}

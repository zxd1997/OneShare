package com.actions;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beans.Order;
import com.opensymphony.xwork2.ActionSupport;
import com.service.OrderService;

@Controller
@Scope("prototype")
public class orderAction extends ActionSupport {
	@Autowired
	private OrderService os;
	HttpSession session=ServletActionContext.getRequest().getSession(); 
	private Order order;
	private String productName;
	public String execute() throws Exception{
		os.createNewOrder((String)session.getAttribute("userName"),productName , order);
		return SUCCESS;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}

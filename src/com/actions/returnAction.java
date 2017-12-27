package com.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.service.OrderService;
@Controller
@Scope("prototype")
public class returnAction extends ActionSupport {
	@Autowired
	private OrderService os;
	private String productName;
	private int orderid;
	public String execute() throws Exception{
		os.returnOrder(orderid);
		return SUCCESS;
	}
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}

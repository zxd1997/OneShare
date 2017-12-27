package com.actions;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beans.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ProductService;

@Controller
@Scope("prototype")
public class indexAction extends ActionSupport {
	@Autowired
	private ProductService ps;
	private List<Product> list;
	public String execute() throws Exception{
		setList(ps.getProducts());
		list=null;
		return SUCCESS;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
}

package com.actions;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beans.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ProductService;

@Controller
@Scope("prototype")
public class searchAction extends ActionSupport {
	@Autowired
	private ProductService ps;
	private String key;
	private List<Product> list;
	private Set<Product> set;
	public String execute() throws Exception{
		setList(ps.getProducts());
		setSet(ps.search(key));
		return SUCCESS;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<Product> getList() {
		return list;
	}
	public void setList(List<Product> list) {
		this.list = list;
	}
	public Set<Product> getSet() {
		return set;
	}
	public void setSet(Set<Product> set) {
		this.set = set;
	}
}

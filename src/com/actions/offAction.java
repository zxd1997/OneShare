package com.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.dao.ProductDao;
import com.opensymphony.xwork2.ActionSupport;
@Controller
@Scope("prototype")
public class offAction extends ActionSupport {
	@Autowired
	private ProductDao productdao;
	private String productName;
	public String execute() throws Exception{
		productdao.deleteProduct(productdao.getProductByName(productName));
		return SUCCESS;
	}
	public ProductDao getProductdao() {
		return productdao;
	}

	public void setProductdao(ProductDao productdao) {
		this.productdao = productdao;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}

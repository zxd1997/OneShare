package com.actions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beans.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ProductService;

@Controller
@Scope("prototype")
public class typeAction extends ActionSupport {
	@Autowired
	private ProductService ps;
	private int Type;
	private List<Product> set;
	public String execute() throws Exception{
		String t="";
		switch (Type) {
		case 1:
			t="体育用品";break;
		case 2:
			t="电子商品";break;
		case 3:
			t="会员账号";break;
		case 4:
			t="学习用品";break;
		case 5:
			t="衣物正装";break;
		}
		set=ps.getProductByType(t);
		return SUCCESS;
	}
	
	public List<Product> getSet() {
		return set;
	}
	public void setSet(List<Product> set) {
		this.set = set;
	}

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		Type = type;
	}
}

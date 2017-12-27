package com.actions;

import com.beans.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.beans.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ProductService;

import java.util.List;

@Controller
@Scope("prototype")
public class productAction extends ActionSupport {
	@Autowired
	private ProductService ps;
	@Autowired
	private CommentService cs;
	private Product product;
	private String productName;
	private List<Comment> list;
	public String execute() throws Exception{
		product=ps.getProductByName(productName);
		setList(cs.getCommentByPid(product.getId()));
		//ActionContext.getContext().put("product", product);
		return SUCCESS;
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	public String getProductName() {
		return productName;
	}

	public List<Comment> getList() {
		return list;
	}
	public void setList(List<Comment> list) {
		this.list =list;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
}

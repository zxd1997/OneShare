package com.actions;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.beans.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ProductServiceImpl;
import com.service.UserServiceImpl;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpSession;
@Controller
@Scope("prototype")
public class shareAction extends ActionSupport {
	HttpSession session=ServletActionContext.getRequest().getSession(); 
	@Autowired
	UserServiceImpl us;
	@Autowired
	ProductServiceImpl ps;
	private Product product;
	private String productName;
	private File uploadImage;
	private String uploadImageFileName;

	public File getUploadImage() {
		return uploadImage;
	}
	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}
	public String getUploadImageFileName() {
		return uploadImageFileName;
	}
	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}
	public String execute() throws Exception{//文件类型判断，文件名修改
		String relPath=ServletActionContext.getServletContext().getRealPath("/images");
		File file=new File(relPath);
		if(!file.exists())
			file.mkdirs();
		System.out.print(uploadImage);
		FileUtils.copyFile(uploadImage, new File(file,uploadImageFileName));
		Date date=new Date();
		product.setPhoto("images"+"/"+uploadImageFileName);
		product.setStartTime(date);
		product.setEndTime(date);
		product.setOnUse(false);
		product.setRecycle(false);
		product.setUserId(us.getUserByName((String)session.getAttribute("userName")).getId());
		setProductName(product.getName());
		ps.add(product);
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
	public void setProductName(String productName) {
		this.productName = productName;
	}
}

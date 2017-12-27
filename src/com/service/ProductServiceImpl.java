package com.service;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.beans.Product;
import com.dao.ProductDao;
@Service 
@Scope("prototype")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	@Override
	public void add(Product product) {
		// TODO 自动生成的方法存根
		productDao.addProduct(product);
	}

	@Override
	public void del(Product product) {
		// TODO 自动生成的方法存根
		productDao.deleteProduct(product);
	}

	@Override
	public void update(Product product) {
		// TODO 自动生成的方法存根
		productDao.updateProduct(product);
	}

	@Override
	public List<Product> getProducts() {
		// TODO 自动生成的方法存根
		return productDao.selectProduct();
	}

	@Override
	public Product getProduct(int id) {
		// TODO 自动生成的方法存根
		return productDao.getProductById(id);
	}

	@Override
	public Product getProductByName(String name) {
		// TODO 自动生成的方法存根
		return productDao.getProductByName(name);
	}

	@Override
	public List<Product> getProductByUser(int id) {
		// TODO 自动生成的方法存根
		return productDao.getProductByUser(id);
	}

	@Override
	public Set<Product> search(String key) {
		// TODO 自动生成的方法存根
		Set<Product> p=new HashSet();
		productDao.setQuerySentence(key);
		productDao.startQuery();
		p=productDao.getProducts();
		return p;
	}

	@Override
	public List<Product> getProductByType(String type) {
		// TODO 自动生成的方法存根
		return productDao.getProductByType(type);
	}

}

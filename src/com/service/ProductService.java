package com.service;

import java.util.List;
import java.util.Set;

import com.beans.Product;

public interface ProductService {
	public void add(Product product);
	public void del(Product product);
	public void update(Product product);
	public List<Product> getProducts();
	public Product getProduct(int id);
	public Product getProductByName(String name); 
	public List<Product> getProductByUser(int id);
	public Set<Product> search(String key);
	public List<Product> getProductByType(String type);
}

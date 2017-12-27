package com.dao;

import java.util.List;
import java.util.Set;

import com.beans.Product;

public interface ProductDao {
	public void addProduct(Product product);
	public void deleteProduct(Product product);
	public void updateProduct(Product product);
	public List<Product> selectProduct();
	public Product getProductById(int id);
	public Product getProductByName(String name);
	public List<Product> getProductByUser(int id);
	public void setQuerySentence(String key);
	public void startQuery();
	public Set<Product> getProducts();
	public List<Product> getProductByType(String type);
}

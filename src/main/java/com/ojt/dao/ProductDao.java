package com.ojt.dao;

import java.util.List;

import com.ojt.model.Product;

public interface ProductDao {
	
	public int addProduct(Product product);
	public Product getProductById(long id);
	public String deleteProductById(long id);
	public List<Product> getAllProduct();
	public Product getProductByName(String name);
	public String updateProduct(Product product);

}

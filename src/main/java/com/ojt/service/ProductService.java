package com.ojt.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.ojt.model.Product;

public interface ProductService {

	public int addProduct(Product product);
	
	public Product getProductById(long id);
	
	public String deleteProductById(long id);
	
	public Object getAllProduct();

	public Product getProductByName(String name);
	
	public String updateProduct(Product product);
}

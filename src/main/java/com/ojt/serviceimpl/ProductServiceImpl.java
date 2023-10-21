package com.ojt.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ojt.dao.ProductDao;
import com.ojt.model.Product;
import com.ojt.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	
	public ProductServiceImpl() {
	
		System.out.println("In Product Service Implementation");
	}

	@Autowired
	private ProductDao dao;
	
	@Override
	public int addProduct(Product product) {
		
		return dao.addProduct(product);
	}

	@Override
	public Product getProductById(long id) {
		
		return dao.getProductById(id);
	}



	@Override
	public String deleteProductById(long id) {
		return dao.deleteProductById(id);
	}

	@Override
	public Object getAllProduct() {
		List<Product> list=dao.getAllProduct();
		if(!list.isEmpty()) {
			return list;
		}
		else {
			return "List is Empty";
		}
		
		
	}

	@Override
	public Product getProductByName(String name) {
		
		return dao.getProductByName(name);
	}

	@Override
	public String updateProduct(Product product) {
		Product listpro=getProductById(product.getProductId());
		if(listpro!=null)
		    return dao.updateProduct(product);
		else
			return "Product not found to update";
	}

}

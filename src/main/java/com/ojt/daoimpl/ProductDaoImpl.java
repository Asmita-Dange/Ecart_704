package com.ojt.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ojt.dao.ProductDao;
import com.ojt.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	List<Product> list=new ArrayList<>();
	
	

	public ProductDaoImpl() {
		list.add(new Product(1,"Book",11,12,3,459.00));
		list.add(new Product(2,"NoteBook",11,12,3,259.00));
		list.add(new Product(3,"Pencil",11,12,3,59.00));
		list.add(new Product(4,"Pen",11,12,3,45));
		
	}

	@Override
	public int addProduct(Product product) {
		Product pid=getProductById(product.getProductId());
		Product pname=getProductByName(product.getProductName());
		if(pid==null && pname==null) {
		list.add(product);
		return 1;
		}
		else {
			return 2;
		}
	}

	@Override
	public Product getProductById(long id) {
		for(Product product:list)
		{
			
			if(product.getProductId()==id)
			{
				
				return product;
				
			}
		}
		return null;
	}

	@Override
	public String deleteProductById(long id) {
		String msg="null";
		if(!list.isEmpty())
		{
		for(Product product:list)
		{
			
			if(product.getProductId()==id)
			{
				list.remove(product);
				msg= "Product deleted successfully";
				break;
			}
			else {
				msg= "Product not found for delete operation";
			}
		}
		}
		else {
			msg="List is empty";
		}
		return msg;
	}

	@Override
	public List<Product> getAllProduct() {
		
		return list;
	}

	@Override
	public Product getProductByName(String name) {
		for(Product product:list)
		{
			
			if(product.getProductName().equals(name))
			{
				
				return product;
				
			}
		}
		return null;
	}

	@Override
	public String updateProduct(Product product) {
		for(Product listpro:list) {
			if(listpro.getProductId()==product.getProductId()) {
				list.set(list.indexOf(listpro), product);
				break;
			}
		}
		return "Updated";
	}
}

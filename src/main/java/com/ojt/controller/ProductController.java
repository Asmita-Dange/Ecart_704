package com.ojt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ojt.model.Product;
import com.ojt.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;//productservice object
	
	@PostMapping("/add-product")
	public String addProduct(@RequestBody Product product)
{
		int status=service.addProduct(product);
		if(status==1) {
			
			return "Data Added...";
			
		}
		else {
		return "Data already exist...";
		}
	}
	
	@GetMapping("/get-product/{id}")
	public Object getProductById(@PathVariable long id)
	{
		Product pid = service.getProductById(id);//Alt +shift+l-->to declare variable ie complete left initialization
		//System.out.println(id);
		if(pid!=null)
		{
		return pid;
		}
		else {
			return "Product not Found..";
			}
		}
	
	@DeleteMapping("/delete-product")
	public String deleteProductById(@RequestParam long id)
	{
		System.out.println(id);//print on console
		return service.deleteProductById(id);
		
	}

	@GetMapping("/get-all-product")
	public Object getAllproduct()
	{
		return service.getAllProduct();
	}
	
	@GetMapping("/get-productByName/{name}")
	public Object getProductByName(@PathVariable String name )
	{
		Product pname = service.getProductByName(name);
		if(pname!=null)
		{
		return pname;
		}
		else {
			return "Product not Found..";
			}
	}
	
	@PutMapping("/update-product")
	public String updateProduct(@RequestBody Product product)
	{
		return service.updateProduct(product);
		
		
		
	}
	
}
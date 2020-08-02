package com.example.ambev.service;

import java.util.List;

import com.example.ambev.model.Product;

public interface ProductService {

	public Product save(Product product);
	public void delete(String id);
	public Product update(String id, Product product);
	public List<Product> getProductByName(String name);
	public Product getProductById(String id);
}
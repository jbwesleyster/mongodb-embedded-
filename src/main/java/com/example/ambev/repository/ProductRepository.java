package com.example.ambev.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.ambev.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
	public List<Product> findByName(String name);
}

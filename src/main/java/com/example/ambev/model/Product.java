package com.example.ambev.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "product")
public class Product {
	@Id
	private String id;
	@Indexed(unique=true)
	private String name;
	@Indexed(unique=true)
	private String description;
	private String price;
	private String brand;
}

package com.example.ambev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.ambev.model.Product;
import com.example.ambev.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/product/v1")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Product.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@ApiOperation(value = "Consultar Produto pelo id", consumes = "application/json", produces = "application/json")
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable("id") String id) {
		return this.productService.getProductById(id);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Product.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@ApiOperation(value = "Consultar Produto pelo id", consumes = "application/json", produces = "application/json")
	@PostMapping
	public Product cria(@RequestBody Product product, UriComponentsBuilder uriBuilder) {
		return this.productService.save(product);
	}

	@PutMapping("/{id}")
	public Product update(@PathVariable("id") String id, @RequestBody Product product) {
		return this.productService.update(id, product);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		this.productService.delete(id);
	}
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Product.class,  responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class) })
	@ApiOperation(value = "Consultar Produto pelo id", consumes = "application/json", produces = "application/json")
	@GetMapping("/find-name/{name}")
	public List<Product> getProductByName(@PathVariable("name") String name) {
		return this.productService.getProductByName(name);
	}
}
